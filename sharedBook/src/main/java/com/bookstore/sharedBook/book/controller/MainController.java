package com.bookstore.sharedBook.book.controller;

import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.common.ListResult;
import com.bookstore.sharedBook.common.ResponseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
