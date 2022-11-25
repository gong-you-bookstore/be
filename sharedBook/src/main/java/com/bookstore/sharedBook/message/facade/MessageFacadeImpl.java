package com.bookstore.sharedBook.message.facade;

import com.bookstore.sharedBook.message.dto.response.MessageBetweenUserResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageBoxResponseDto;
import com.bookstore.sharedBook.message.entity.Message;
import com.bookstore.sharedBook.message.repository.MessageRepositoryImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MessageFacadeImpl implements MessageFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;

    private final MessageRepositoryImpl messageRepository;

    @Override
    public List<MessageBetweenUserResponseDto> getAllMessagesByShelfId(String token, String shelfId, String email1, String email2) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        String email1Id = userService.getUserIdFromUserEmail(email1);
        String email2Id = userService.getUserIdFromUserEmail(email2);
        List<Message> ret = messageRepository.findAllMessagesByShelfIdAndTwoUsers(UUID.fromString(shelfId), UUID.fromString(email1Id), UUID.fromString(email2Id));
        List<MessageBetweenUserResponseDto> res = new ArrayList<>();
        for(Message message : ret){
            String senderEmail = userService.getUserEmailFromUserId(message.getSender().toString());
            res.add(MessageBetweenUserResponseDto.toMessageBetweenUserResponseDto(message, senderEmail));
        }
        return res;
    }

    @Override
    public List<MessageBoxResponseDto> getAllMyMessages(String token) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        String userEmail = userService.getUserEmailFromUserId(userId);
        //내가 받은 편지 모두 가져오기
        List<Message> receivedMessages = messageRepository.findAllByReceiverId(UUID.fromString(userId));
        //내가 보낸 편지 모두 가져오기
        List<Message> sentMessages = messageRepository.findAllBySenderId(UUID.fromString(userId));
        List<MessageBoxResponseDto> res = new ArrayList<>();
        List<String> counterpartCheck = new ArrayList<>();
        for(Message message : receivedMessages){
            String senderEmail = userService.getUserEmailFromUserId(message.getSender().toString());
            if (!counterpartCheck.contains(senderEmail)){
                counterpartCheck.add(senderEmail);
                MessageBoxResponseDto responseDto = MessageBoxResponseDto.toMessageBoxResponseDto(message, userEmail, senderEmail);
                res.add(responseDto);
            }
        }

        for(Message message : sentMessages){
            String receiverEmail = userService.getUserEmailFromUserId(message.getReceiver().toString());
            if(!counterpartCheck.contains(receiverEmail)){
                counterpartCheck.add(receiverEmail);
                MessageBoxResponseDto responseDto = MessageBoxResponseDto.toMessageBoxResponseDto(message, userEmail, receiverEmail);
                res.add(responseDto);
            }
        }
        return res;
    }

}
