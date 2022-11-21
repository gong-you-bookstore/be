package com.bookstore.sharedBook.user.repository;

import com.bookstore.sharedBook.user.entity.QUser;
import com.bookstore.sharedBook.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final UserJpaRepository userJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;
    @Override
    public Optional<User> findUserByEmail(String email) {
        return userJpaRepository.findUserByEmail(email);
    }

    @Override
    public String findUserEmailByUserId(UUID userId) {
        return jpaQueryFactory
                .select(user.email)
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();
    }

}
