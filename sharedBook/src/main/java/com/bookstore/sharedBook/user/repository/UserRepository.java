package com.bookstore.sharedBook.user.repository;

import com.bookstore.sharedBook.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findUserByEmail(String email);
    String findUserEmailByUserId(UUID userId);

}
