package com.bookstore.sharedBook.survey.facade;

import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;

public interface SurveyFacade {
    void saveSurvey(String userId, SaveSurveyRequestDto saveSurveyRequestDto);
}
