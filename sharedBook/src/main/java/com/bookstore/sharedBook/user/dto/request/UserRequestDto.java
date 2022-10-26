package com.bookstore.sharedBook.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestDto {
    private String name;
    private String nickname;
    private String email;
    private String password;
    private Integer age;
    private String gender;
}
