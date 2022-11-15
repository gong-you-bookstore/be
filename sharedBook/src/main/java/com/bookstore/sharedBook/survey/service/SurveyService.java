package com.bookstore.sharedBook.survey.service;

import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;

import java.util.List;

public interface SurveyService {
    void saveInterestGenres(String userId, List<Integer> genres);
}
