package com.bookstore.sharedBook.survey.repository;

import com.bookstore.sharedBook.survey.entity.Interest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InterestRepositoryImpl implements InterestRepository{
    private final InterestJpaRepository interestJpaRepository;

    @Override
    public void save(Interest interest) {
        interestJpaRepository.save(interest);
    }
}
