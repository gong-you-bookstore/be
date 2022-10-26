package com.bookstore.sharedBook.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponse {
    SUCCESS(200, "성공했습니다.");

    private final int code;
    private final String msg;
}
