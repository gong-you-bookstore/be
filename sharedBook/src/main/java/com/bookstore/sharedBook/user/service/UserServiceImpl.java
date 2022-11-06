package com.bookstore.sharedBook.user.service;

import com.bookstore.sharedBook.config.exception.IdException;
import com.bookstore.sharedBook.config.exception.PasswordException;
import com.bookstore.sharedBook.user.dto.request.SignInRequestDto;
import com.bookstore.sharedBook.user.dto.request.SignUpRequestDto;
import com.bookstore.sharedBook.user.dto.response.SignInResponseDto;
import com.bookstore.sharedBook.user.dto.response.SignUpResponseDto;
import com.bookstore.sharedBook.user.entity.User;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public SignUpResponseDto register(SignUpRequestDto signUpRequestDto){
        String encodedPassword = passwordEncoder.encode(signUpRequestDto.getPassword());
        User user = User.builder()
                .name(signUpRequestDto.getName())
                .nickname(signUpRequestDto.getNickname())
                .email(signUpRequestDto.getEmail())
                .password(encodedPassword)
                .roles(Collections.singletonList("ROLE_USER"))
                .age(signUpRequestDto.getAge())
                .gender(signUpRequestDto.getGender())
                .build();

        userRepository.save(user);
        return SignUpResponseDto.toUserResponseDto(user);
    }

    @Override
    public SignInResponseDto login(SignInRequestDto signInRequestDto) {
        User user = userRepository.findUserByEmail(signInRequestDto.getEmail()).orElseThrow(IdException::new);
        if (!passwordEncoder.matches(signInRequestDto.getPassword(), user.getPassword())) {
            throw new PasswordException();
        }
        String accessToken = jwtTokenProvider.createAccessToken(user.getId().toString(), user.getRoles());
        return SignInResponseDto.toSignInResponseDto(signInRequestDto.getEmail(), accessToken);
    }



}
