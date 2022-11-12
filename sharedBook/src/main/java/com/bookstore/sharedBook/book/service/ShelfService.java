package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.entity.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf save(String userId, SaveBookRequestDto saveBookRequestDto);
    List<String> getUserEmailsByIsbn(Long isbn);
}
