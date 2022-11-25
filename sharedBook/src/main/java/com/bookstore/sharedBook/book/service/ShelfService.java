package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.PatchShelfStatusRequestDto;
import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.ShelfDetailResponseDto;
import com.bookstore.sharedBook.book.entity.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf save(String userId, SaveBookRequestDto saveBookRequestDto);
    List<String> getUserEmailsByIsbn(Long isbn);
    Shelf getShelf(Long isbn, String userId);
    List<Shelf> getShelfByUserId(String userId);
    void patchShelfStatus(String shelfId, String status);
    Integer getTokenFromShelf(String shelfId);
}
