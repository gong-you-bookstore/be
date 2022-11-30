package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.PatchShelfStatusRequestDto;
import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import com.bookstore.sharedBook.book.entity.Book;
import com.bookstore.sharedBook.book.entity.Shelf;
import com.bookstore.sharedBook.book.entity.ShelfStatus;
import com.bookstore.sharedBook.book.repository.BookRepositoryImpl;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.book.service.ShelfServiceImpl;
import com.bookstore.sharedBook.config.exception.CustomException;
import com.bookstore.sharedBook.file.service.FileServiceImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookFacadeImpl implements BookFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final BookServiceImpl bookService;
    private final ShelfServiceImpl shelfService;
    private final UserServiceImpl userService;
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
    public ShelfDetailResponseDto getShelf(String token, Long isbn, String userEmail) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        Shelf shelf = shelfService.getShelf(isbn, userService.getUserIdFromUserEmail(userEmail));
        List<String> fileNameList = fileService.getFileNamesByShelfId(shelf.getId().toString());
        List<String> fileUrlList = fileService.getFileUrlFromFileNameList(fileNameList);
        return ShelfDetailResponseDto.toShelfResponseDto(shelf, fileUrlList);
    }

    @Override
    public List<BookResponseDto> getBookByUserId(String token) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        List<Shelf> shelves = shelfService.getShelfByUserId(userId);
        List<Long> isbnList = new ArrayList<>();
        List<BookResponseDto> res = new ArrayList<>();
        for(Shelf shelf : shelves){
            if(!isbnList.contains(shelf.getIsbn())){
                isbnList.add(shelf.getIsbn());
            }
        }
        for(Long isbn:isbnList){
            BookDetailResponseDto bookDetail = bookService.getBookById(isbn);
            BookResponseDto responseDto = BookResponseDto.builder()
                    .isbn(bookDetail.getIsbn())
                    .title(bookDetail.getTitle())
                    .kdc(bookDetail.getKdc())
                    .thumbnail(bookDetail.getThumbnail())
                    .build();
            res.add(responseDto);
        }
        return res;
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
