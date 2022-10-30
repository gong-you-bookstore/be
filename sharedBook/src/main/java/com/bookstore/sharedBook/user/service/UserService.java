package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.user.dto.request.SignInRequestDto;
import com.bookstore.sharedBook.user.dto.request.SignUpRequestDto;
import com.bookstore.sharedBook.user.dto.response.SignInResponseDto;
import com.bookstore.sharedBook.user.dto.response.SignUpResponseDto;

public interface UserService {
    SignUpResponseDto register(SignUpRequestDto signUpRequestDto);
    SignInResponseDto login(SignInRequestDto signInRequestDto);
}
