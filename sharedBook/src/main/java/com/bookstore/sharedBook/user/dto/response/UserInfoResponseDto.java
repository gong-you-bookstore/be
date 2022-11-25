package com.bookstore.sharedBook.user.dto.response;

import com.bookstore.sharedBook.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserInfoResponseDto {
    private String email;
    private String name;
    private Integer token;

    public static UserInfoResponseDto toUserInfoResponseDto(User user){
        return UserInfoResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .token(user.getToken())
                .build();
    }
}
