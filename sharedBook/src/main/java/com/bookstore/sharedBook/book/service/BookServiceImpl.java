package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.response.BookDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.BookResponseDto;
import com.bookstore.sharedBook.book.entity.Book;
import com.bookstore.sharedBook.book.repository.BookRepositoryImpl;
import com.bookstore.sharedBook.config.exception.CustomException;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.bookstore.sharedBook.config.exception.ErrorCode.BOOK_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookServiceImpl implements BookService{
    private final ShelfServiceImpl shelfService;
    private final BookRepositoryImpl bookRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public BookResponseDto save(String token, SaveBookRequestDto saveBookRequestDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        Book book = Book.builder()
                    .isbn(saveBookRequestDto.getIsbn())
                    .title(saveBookRequestDto.getTitle())
                    .author(saveBookRequestDto.getAuthor().get(0))
                    .content(saveBookRequestDto.getContent())
                    .thumbnail(saveBookRequestDto.getThumbnail())
                    .publisher(saveBookRequestDto.getPublisher())
                    .kdc(saveBookRequestDto.getKdc())
                    .price(saveBookRequestDto.getPrice())
                    .build();
            return BookResponseDto.toBookResponseDto(bookRepository.save(book));
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookResponseDto::toBookResponseDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<BookResponseDto> getAllSavedBooksByUser(String token) {
//        String userId = jwtTokenProvider.getUserIdFromToken(token);
//        return bookRepository.findAllBooksByUserId(userId).stream()
//                .map(BookResponseDto::toBookResponseDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public BookDetailResponseDto getBookById(Long isbn) {
        Book book = bookRepository.findBookById(isbn).orElseThrow(()->new CustomException(BOOK_NOT_FOUND));
        List<String> userList = shelfService.getUserEmailsByIsbn(isbn);
        return BookDetailResponseDto.toBookDetailResponseDto(book, userList);
    }

//    @Override
//    public void patchBookStatus(String token, Long isbn, String status) {
//        String userId = jwtTokenProvider.getUserIdFromToken(token);
//
//        if(status.equalsIgnoreCase(BookStatus.READ.getState()) ||
//        status.equalsIgnoreCase(BookStatus.UNSOLD.getState()) ||
//        status.equalsIgnoreCase(BookStatus.SOLD.getState())){
//            bookRepository.patchBookStatus(isbn,UUID.fromString(userId), status);
//        }
//    }

//    @Override
//    public boolean delete(String token, String bookId) {
//        String userId = jwtTokenProvider.getUserIdFromToken(token);
//        long count = bookRepository.delete(UUID.fromString(userId), UUID.fromString(bookId));
//        if(count==0){
//            throw new CustomException(BOOK_NOT_FOUND);
//        }else{
//            return true;
//        }
//
//    }
}
