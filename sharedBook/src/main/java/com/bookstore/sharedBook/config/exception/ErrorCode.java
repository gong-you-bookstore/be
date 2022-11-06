package com.bookstore.sharedBook.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BOOK_NOT_FOUND(false, HttpStatus.BAD_REQUEST, "책이 존재하지 않습니다.");

    private final Boolean success;
    private final HttpStatus httpStatus;
    private final String message;
}
