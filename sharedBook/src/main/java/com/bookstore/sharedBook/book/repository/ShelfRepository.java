package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Shelf;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShelfRepository {
    Shelf save(Shelf shelf);
    List<String> getUserEmailsByIsbn(Long isbn);
    Shelf getShelf(Long isbn, UUID userId);
    long patchShelfStatus(UUID shelfId, String status);
}
