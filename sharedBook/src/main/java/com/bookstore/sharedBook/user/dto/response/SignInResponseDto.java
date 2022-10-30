package com.bookstore.sharedBook.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SignInResponseDto {
    private String email;
    private String accessToken;

    public static SignInResponseDto toSignInResponseDto(String email, String accessToken){
        return SignInResponseDto.builder()
                .email(email)
                .accessToken(accessToken)
                .build();
    }
}
