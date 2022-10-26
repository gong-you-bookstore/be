package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.user.dto.request.UserRequestDto;
import com.bookstore.sharedBook.user.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto);
}
