package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Shelf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShelfRepositoryImpl implements ShelfRepository{
    private final ShelfJpaRepository shelfJpaRepository;

    @Override
    public Shelf save(Shelf shelf) {
        return shelfJpaRepository.save(shelf);
    }
}
