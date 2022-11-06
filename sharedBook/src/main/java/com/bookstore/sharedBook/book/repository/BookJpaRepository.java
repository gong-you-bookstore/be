package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByUserId(UUID userId);
}
