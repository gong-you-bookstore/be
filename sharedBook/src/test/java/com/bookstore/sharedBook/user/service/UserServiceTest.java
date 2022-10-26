package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.user.dto.request.UserRequestDto;
import com.bookstore.sharedBook.user.dto.response.UserResponseDto;
import com.bookstore.sharedBook.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Test
    @DisplayName("회원가입 : 새로운 유저 생성")
    public void create(){
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .name("테스트")
                .nickname("닉네임")
                .email("test@gmail.com")
                .password("12345678")
                .age(20)
                .gender("MALE")
                .build();

        UserResponseDto userResponseDto = userService.register(userRequestDto);

        assertThat(userResponseDto.getNickname()).isEqualTo("닉네임");
        assertThat(userResponseDto.getEmail()).isEqualTo("test@gmail.com");

    }

}