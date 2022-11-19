package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import com.bookstore.sharedBook.book.entity.Shelf;
import com.bookstore.sharedBook.book.repository.BookRepositoryImpl;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.book.service.ShelfServiceImpl;
import com.bookstore.sharedBook.file.service.FileServiceImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

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
}
