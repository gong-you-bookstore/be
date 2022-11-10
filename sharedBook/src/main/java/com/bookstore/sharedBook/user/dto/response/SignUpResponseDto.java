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
    private String name;

    public static SignUpResponseDto toUserResponseDto (User user){
        return SignUpResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
