package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.user.dto.request.UserRequestDto;
import com.bookstore.sharedBook.user.dto.response.UserResponseDto;
import com.bookstore.sharedBook.user.entity.User;
import com.bookstore.sharedBook.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserResponseDto register(UserRequestDto userRequestDto){
        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());
        User user = User.builder()
                .name(userRequestDto.getName())
                .nickname(userRequestDto.getNickname())
                .email(userRequestDto.getEmail())
                .password(encodedPassword)
                .age(userRequestDto.getAge())
                .gender(userRequestDto.getGender())
                .build();

        userRepository.save(user);
        return UserResponseDto.toUserResponseDto(user);
    }
}
