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
public class UserResponseDto {
    private String email;
    private String nickname;

    public static UserResponseDto toUserResponseDto (User user){
        return UserResponseDto.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
    }
}
