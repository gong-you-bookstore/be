package com.bookstore.sharedBook.survey.facade;

import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;
import com.bookstore.sharedBook.survey.service.SurveyServiceImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class SurveyFacadeImpl implements SurveyFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;
    private final SurveyServiceImpl surveyService;


    @Override
    public void saveSurvey(String token, SaveSurveyRequestDto saveSurveyRequestDto) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        userService.updateSurveyInfo(userId, saveSurveyRequestDto);
        surveyService.saveInterestGenres(userId, saveSurveyRequestDto.getGenre());
    }
}
