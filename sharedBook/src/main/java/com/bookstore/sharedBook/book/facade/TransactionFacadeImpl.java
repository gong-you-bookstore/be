package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.RequestTransactionDto;
import com.bookstore.sharedBook.book.dto.request.RespondTransactionDto;
import com.bookstore.sharedBook.book.entity.ShelfStatus;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.book.service.ShelfServiceImpl;
import com.bookstore.sharedBook.config.exception.CustomException;
import com.bookstore.sharedBook.config.exception.ErrorCode;
import com.bookstore.sharedBook.message.service.MessageServiceImpl;
import com.bookstore.sharedBook.user.dto.response.UserInfoResponseDto;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class TransactionFacadeImpl implements TransactionFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;
    private final ShelfServiceImpl shelfService;
    private final MessageServiceImpl messageService;

    @Override
    public void requestTransaction(String accessToken, RequestTransactionDto requestTransactionDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(accessToken);
        String userEmail = userService.getUserEmailFromUserId(userId);
        //본인이 거래 요청하고 수락 불가
        if(requestTransactionDto.getReceiverEmail().equals(userEmail)){
            throw new CustomException(ErrorCode.TRANSACTION_INVALID);
        }
        //판매자 본인에게 거래 요청 불가
        String shelfUploaderId = shelfService.getShelfUploaderIdByShelfId(requestTransactionDto.getShelfId());
        String shelfUploaderEmail = userService.getUserEmailFromUserId(shelfUploaderId);
        if(shelfUploaderEmail.equals(requestTransactionDto.getReceiverEmail())){
            throw new CustomException(ErrorCode.TRANSACTION_INVALID);
        }
        //요청한 자의 토큰이 모자라면 에러
        int userToken = userService.getUserInfo(accessToken).getToken();
        int shelfToken = shelfService.getTokenFromShelf(requestTransactionDto.getShelfId());
        if (userToken - shelfToken < 0){
            throw new CustomException(ErrorCode.TOKEN_NOT_ENOUGH);
        }
        //책의 상태 바꾸고
        shelfService.patchShelfStatus(requestTransactionDto.getShelfId(), ShelfStatus.PENDING.getState());
        //메시지 보내고
        messageService.sendRequestTransactionMessage(accessToken, requestTransactionDto.getShelfId(), requestTransactionDto.getReceiverEmail());
    }

    @Override
    public void acceptTransaction(String accessToken, RespondTransactionDto respondTransactionDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(accessToken);
        shelfService.patchShelfStatus(respondTransactionDto.getShelfId(), ShelfStatus.SOLD.getState());
        messageService.sendRespondTransactionMessage(accessToken, respondTransactionDto.getShelfId(), respondTransactionDto.getReceiverEmail());

        //토큰 업데이트
        int tokenFromShelf = shelfService.getTokenFromShelf(respondTransactionDto.getShelfId());
        //판매자
        userService.updateToken(userId, tokenFromShelf, false);
        //소비자
        String receiverId = userService.getUserIdFromUserEmail(respondTransactionDto.getReceiverEmail());
        userService.updateToken(receiverId, tokenFromShelf, true);

    }

}
