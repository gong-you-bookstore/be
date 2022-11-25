package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    BookResponseDto save(String token, SaveBookRequestDto saveBookRequestDto);
    List<BookResponseDto> getAllBooks();
    List<BookResponseDto> getAllBooksByGenre(List<String> genreList);

    BookDetailResponseDto getBookById(Long isbn);
    //void patchBookStatus(String token, Long isbn, String status);
    //boolean delete(String token, String bookId);

}
