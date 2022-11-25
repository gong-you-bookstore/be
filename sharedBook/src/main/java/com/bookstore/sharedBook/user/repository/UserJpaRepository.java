package com.bookstore.sharedBook.user.repository;

import com.bookstore.sharedBook.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(UUID id);
    UUID findIdByEmail(String email);
}
