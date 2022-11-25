package com.bookstore.sharedBook.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BOOK_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "책이 존재하지 않습니다."),
    USER_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "아이디가 존재하지 않습니다."),
    MESSAGE_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "메시지가 존재하지 않습니다."),
    RECEIVER_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "수신자가 존재하지 않습니다."),
    PASSWORD_NOT_MATCH(false, HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    JWT_TOKEN_EXPIRED(false, HttpStatus.BAD_REQUEST, "JWT 토큰이 만료되었습니다."),
    JWT_TOKEN_ERROR(false, HttpStatus.BAD_REQUEST, "JWT 토큰이 잘못되었습니다.");

    private final Boolean success;
    private final HttpStatus httpStatus;
    private final String message;
}
