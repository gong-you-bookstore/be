package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserServiceImpl userService;

//    @Test
//    @DisplayName("회원가입 : 새로운 유저 생성")
//    public void create(){
//        SignUpRequestDto signUpRequestDto = SignUpRequestDto.builder()
//                .name("테스트")
//                .nickname("닉네임")
//                .email("test@gmail.com")
//                .password("12345678")
//                .age(20)
//                .gender("MALE")
//                .build();
//
//        SignUpResponseDto signUpResponseDto = userService.register(signUpRequestDto);
//
//        assertThat(signUpResponseDto.getNickname()).isEqualTo("닉네임");
//        assertThat(signUpResponseDto.getEmail()).isEqualTo("test@gmail.com");
//
//    }

}