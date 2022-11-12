package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import java.util.List;

public interface BookService {
    ShelfResponseDto save(String token, SaveBookRequestDto saveBookRequestDto);
    List<BookResponseDto> getAllBooks();
    //List<BookResponseDto> getAllSavedBooksByUser(String token);
    BookDetailResponseDto getBookById(Long isbn);
    //void patchBookStatus(String token, Long isbn, String status);
    //boolean delete(String token, String bookId);

}
