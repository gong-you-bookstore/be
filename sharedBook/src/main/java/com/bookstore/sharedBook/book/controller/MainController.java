package com.bookstore.sharedBook.book.controller;

import com.bookstore.sharedBook.book.dto.request.BookGenreRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.common.ListResult;
import com.bookstore.sharedBook.common.ResponseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/")
public class MainController {
    private final BookServiceImpl bookService;
    private final ResponseService responseService;

    @GetMapping
    public ResponseEntity<ListResult<BookResponseDto>> getAllBooks(){
        return new ResponseEntity<>(responseService.getListResult(bookService.getAllBooks()), HttpStatus.OK);
    }

    @GetMapping("/genre")
    public ResponseEntity<ListResult<BookResponseDto>> getAllBooksByKdc(
            @RequestBody BookGenreRequestDto bookGenreRequestDto){
        return new ResponseEntity<>(responseService.getListResult(bookService.getAllBooksByGenre(bookGenreRequestDto.getGenre())), HttpStatus.OK);
    }
}
