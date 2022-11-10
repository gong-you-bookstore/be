package com.bookstore.sharedBook.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
