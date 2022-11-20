package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.QShelf;
import com.bookstore.sharedBook.book.entity.Shelf;
import com.bookstore.sharedBook.user.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ShelfRepositoryImpl implements ShelfRepository{
    private final ShelfJpaRepository shelfJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QShelf shelf = QShelf.shelf;
    private final QUser user = QUser.user;

    @Override
    public Shelf save(Shelf shelf) {
        return shelfJpaRepository.save(shelf);
    }

    @Override
    public List<String> getUserEmailsByIsbn(Long isbn) {
        return jpaQueryFactory
                .select(user.email)
                .from(shelf)
                .leftJoin(user).on(shelf.userId.eq(user.id))
                .where(shelf.isbn.eq(isbn))
                .fetch();
    }

    @Override
    public Shelf getShelf(Long isbn, UUID userId) {
        List<Shelf> ret = jpaQueryFactory
                .selectFrom(shelf)
                .where(shelf.isbn.eq(isbn), shelf.userId.eq(userId))
                .fetch();
        return ret.get(0);
    }
}
