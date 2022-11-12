package com.bookstore.sharedBook.book.repository;

import com.bookstore.sharedBook.book.entity.Book;
import com.bookstore.sharedBook.book.entity.QBook;
import com.bookstore.sharedBook.config.DataTypeConverter;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository{
    private final BookJpaRepository bookJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QBook book = QBook.book;

    @Override
    public Book save(Book book) {
        return bookJpaRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

//    @Override
//    public List<Book> findAllBooksByUserId(String userId) {
//        //return bookJpaRepository.findAllByUserId(UUID.fromString(userId));
//        return jpaQueryFactory
//                .selectFrom(book)
//                .where(book.userId.eq(UUID.fromString(userId)))
//                .fetch();
//    }

    @Override
    public Optional<Book> findBookById(Long isbn) {
        return bookJpaRepository.findById(isbn);
    }

//    @Override
//    public long patchBookStatus(Long isbn, UUID userId, String status) {
//        return jpaQueryFactory
//                .update(book)
//                .set(book.status, status)
//                .where(book.isbn.eq(isbn), book.userId.eq(userId))
//                .execute();
//    }

//    @Override
//    public long delete(UUID userId, UUID bookId) {
//        return jpaQueryFactory
//                .delete(book)
//                .where(book.userId.eq(userId), book.id.eq(bookId))
//                .execute();
//    }
}
