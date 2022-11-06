package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    List<Book> findAllBooksByUserId(String userId);
    Optional<Book> findBookById(Long isbn);
    long patchBookStatus(Long isbn, UUID userId, String status);
    long delete(UUID userId, UUID bookId);
}
