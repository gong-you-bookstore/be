package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;
import com.bookstore.sharedBook.user.dto.request.SignInRequestDto;
import com.bookstore.sharedBook.user.dto.request.SignUpRequestDto;
import com.bookstore.sharedBook.user.dto.response.SignInResponseDto;
import com.bookstore.sharedBook.user.dto.response.SignUpResponseDto;
import com.bookstore.sharedBook.user.dto.response.UserInfoResponseDto;

import java.util.UUID;

public interface UserService {
    SignUpResponseDto register(SignUpRequestDto signUpRequestDto);
    SignInResponseDto login(SignInRequestDto signInRequestDto);
    void updateSurveyInfo(String userId, SaveSurveyRequestDto saveSurveyRequestDto);
    String getUserIdFromUserEmail(String email);
    boolean getUserExistence(String email);
    String getUserEmailFromUserId(String userId);
    void updateToken(String userId, Integer token, boolean consumed);
    UserInfoResponseDto getUserInfo(String accessToken);
}
