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
public class SignUpResponseDto {
    private String email;
    private String nickname;

    public static SignUpResponseDto toUserResponseDto (User user){
        return SignUpResponseDto.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
    }
}
