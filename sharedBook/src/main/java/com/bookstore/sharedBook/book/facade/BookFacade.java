package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.ShelfDetailResponseDto;
import com.bookstore.sharedBook.book.dto.response.ShelfResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookFacade {
    ShelfResponseDto save(String token, SaveBookRequestDto saveBookRequestDto, List<MultipartFile> multipartFileList);
    ShelfDetailResponseDto getShelf(String token, ShelfDetailRequestDto shelfDetailRequestDto);
}
