package com.bookstore.sharedBook.book.controller;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.dto.response.SaveBookResponseDto;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.common.CommonResult;
import com.bookstore.sharedBook.common.ListResult;
import com.bookstore.sharedBook.common.ResponseService;
import com.bookstore.sharedBook.common.SingleResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<SingleResult<SaveBookResponseDto>> saveBook(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestBody SaveBookRequestDto saveBookRequestDto){
        return new ResponseEntity<>(responseService.getSingleResult(bookService.save(accessToken, saveBookRequestDto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ListResult<BookResponseDto>> getAllBooks(){
        return new ResponseEntity<>(responseService.getListResult(bookService.getAllBooks()), HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<ListResult<BookResponseDto>> getAllSavedBooksByUser(
            @RequestHeader("X-AUTH-TOKEN") String accessToken){
        return new ResponseEntity<>(responseService.getListResult(bookService.getAllSavedBooksByUser(accessToken)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<CommonResult> deleteBook(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestParam String bookId){
        return new ResponseEntity<>(responseService.getSimpleResult(bookService.delete(accessToken, bookId)), HttpStatus.OK);
        }
    }
