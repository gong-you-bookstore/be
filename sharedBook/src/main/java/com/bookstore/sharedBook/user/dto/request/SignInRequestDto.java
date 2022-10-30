package com.bookstore.sharedBook.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInRequestDto {
    private String email;
    private String password;
}