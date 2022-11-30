package com.bookstore.sharedBook.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BOOK_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "책이 존재하지 않습니다."),
    USER_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "아이디가 존재하지 않습니다."),
    USER_ALREADY_EXIST(false, HttpStatus.BAD_REQUEST, "아이디가 이미 존재합니다."),
    MESSAGE_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "메시지가 존재하지 않습니다."),
    RECEIVER_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "수신자가 존재하지 않습니다."),
    PASSWORD_NOT_MATCH(false, HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    JWT_TOKEN_EXPIRED(false, HttpStatus.BAD_REQUEST, "JWT 토큰이 만료되었습니다."),
    JWT_TOKEN_ERROR(false, HttpStatus.BAD_REQUEST, "JWT 토큰이 잘못되었습니다."),
    TRANSACTION_INVALID(false, HttpStatus.BAD_REQUEST, "잘못된 거래 요청입니다."),
    TOKEN_NOT_ENOUGH(false, HttpStatus.BAD_REQUEST, "토큰이 부족합니다.");

    private final Boolean success;
    private final HttpStatus httpStatus;
    private final String message;
}
