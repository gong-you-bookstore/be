package com.bookstore.sharedBook.book.controller;

import com.bookstore.sharedBook.book.dto.request.RequestTransactionDto;
import com.bookstore.sharedBook.book.dto.request.RespondTransactionDto;
import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.*;
import com.bookstore.sharedBook.book.facade.BookFacadeImpl;
import com.bookstore.sharedBook.book.facade.TransactionFacadeImpl;
import com.bookstore.sharedBook.book.service.BookServiceImpl;
import com.bookstore.sharedBook.book.service.ShelfServiceImpl;
import com.bookstore.sharedBook.common.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;
    private final ShelfServiceImpl shelfService;
    private final BookFacadeImpl bookFacade;
    private final TransactionFacadeImpl transactionFacade;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<SingleResult<ShelfResponseDto>> saveBook(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestPart("request") SaveBookRequestDto saveBookRequestDto,
            @RequestPart(value = "imgs", required = false) List<MultipartFile> multipartFiles){
        return new ResponseEntity<>(responseService.getSingleResult(bookFacade.save(accessToken, saveBookRequestDto, multipartFiles)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ListResult<BookResponseDto>> getAllBooks(){
        return new ResponseEntity<>(responseService.getListResult(bookService.getAllBooks()), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<SingleResult<BookDetailResponseDto>> getBookDetail(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @PathVariable Long isbn){
        return new ResponseEntity<>(responseService.getSingleResult(bookService.getBookById(isbn)), HttpStatus.OK);
    }

    @GetMapping("/shelf")
    public ResponseEntity<SingleResult<ShelfDetailResponseDto>> getShelfDetail(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestBody ShelfDetailRequestDto shelfDetailRequestDto){
        return new ResponseEntity<>(responseService.getSingleResult(bookFacade.getShelf(accessToken, shelfDetailRequestDto)), HttpStatus.OK);
    }

    @PostMapping("/trade/request")
    public ResponseEntity<CommonResult> requestTransaction(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestBody RequestTransactionDto requestTransactionDto){
        transactionFacade.requestTransaction(accessToken, requestTransactionDto);
        return new ResponseEntity<>(responseService.getSimpleResult(true), HttpStatus.OK);
    }

    @PostMapping("/trade/respond")
    public ResponseEntity<CommonResult> respondTransaction(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestBody RespondTransactionDto respondTransactionDto){
        transactionFacade.acceptTransaction(accessToken, respondTransactionDto);
        return new ResponseEntity<>(responseService.getSimpleResult(true), HttpStatus.OK);
    }

//    @GetMapping("/my")
//    public ResponseEntity<ListResult<BookResponseDto>> getAllSavedBooksByUser(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken){
//        return new ResponseEntity<>(responseService.getListResult(bookService.getAllSavedBooksByUser(accessToken)), HttpStatus.OK);
//    }

//    @DeleteMapping
//    public ResponseEntity<CommonResult> deleteBook(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken,
//            @RequestParam String bookId){
//        return new ResponseEntity<>(responseService.getSimpleResult(bookService.delete(accessToken, bookId)), HttpStatus.OK);
//        }
    }
