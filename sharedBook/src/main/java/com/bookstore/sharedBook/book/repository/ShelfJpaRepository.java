package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShelfJpaRepository extends JpaRepository<Shelf, UUID> {
    List<UUID> findUserIdByIsbn(Long isbn);
}
