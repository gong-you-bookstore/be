package com.bookstore.sharedBook.survey.repository;

import com.bookstore.sharedBook.survey.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InterestJpaRepository extends JpaRepository<Interest, UUID> {
}
