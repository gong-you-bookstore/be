package com.bookstore.sharedBook.survey.service;

import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;
import com.bookstore.sharedBook.survey.entity.Interest;
import com.bookstore.sharedBook.survey.repository.InterestRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyServiceImpl implements SurveyService{
    private final InterestRepositoryImpl interestRepository;

    @Override
    public void saveInterestGenres(String userId, List<Integer> genres) {
        for(Integer genre : genres){
            Interest interest = Interest.builder()
                    .userId(UUID.fromString(userId))
                    .genre(genre)
                    .build();
            interestRepository.save(interest);
        }
    }
}
