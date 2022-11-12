package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Shelf;

import java.util.Optional;

public interface ShelfRepository {
    Shelf save(Shelf shelf);
}
