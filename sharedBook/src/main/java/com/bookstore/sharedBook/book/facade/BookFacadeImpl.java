package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.PatchShelfStatusRequestDto;
import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.ShelfDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import com.bookstore.sharedBook.book.entity.Shelf;
import com.bookstore.sharedBook.book.entity.ShelfStatus;
import com.bookstore.sharedBook.book.repository.BookRepositoryImpl;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.book.service.ShelfServiceImpl;
import com.bookstore.sharedBook.config.exception.CustomException;
import com.bookstore.sharedBook.file.service.FileServiceImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class BookFacadeImpl implements BookFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final BookServiceImpl bookService;
    private final ShelfServiceImpl shelfService;
    private final FileServiceImpl fileService;
    private final BookRepositoryImpl bookRepository;

    @Override
    public ShelfResponseDto save(String token, SaveBookRequestDto saveBookRequestDto, List<MultipartFile> multipartFileList) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        if(!bookRepository.findBookById(saveBookRequestDto.getIsbn()).isPresent()){
            bookService.save(token, saveBookRequestDto);
        }
        Shelf shelf = shelfService.save(userId, saveBookRequestDto);
        if(multipartFileList != null){
            fileService.save(multipartFileList, shelf.getId().toString(), userId);
        }
        return ShelfResponseDto.toShelfResponseDto(shelf);
    }

    @Override
    public ShelfDetailResponseDto getShelf(String token, ShelfDetailRequestDto shelfDetailRequestDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        Shelf shelf = shelfService.getShelf(shelfDetailRequestDto);
        List<String> fileNameList = fileService.getFileIdsByShelfId(shelf.getId().toString());
        return ShelfDetailResponseDto.toShelfResponseDto(shelf, fileNameList);
    }

    @Override
    public void tradeRequest(String token, PatchShelfStatusRequestDto patchShelfStatusRequestDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        shelfService.patchShelfStatus(patchShelfStatusRequestDto.getShelfId(), patchShelfStatusRequestDto.getRequest());
//        if (patchShelfStatusRequestDto.getRequest().equals(ShelfStatus.PENDING)){
//
//        }else{
//            throw new CustomException(()->)
//        }
    }

    @Override
    public void tradeResponse(String token, PatchShelfStatusRequestDto patchShelfStatusRequestDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
    }


}
