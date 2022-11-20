package com.bookstore.sharedBook.message.dto.request;

import lombok.Getter;

@Getter
public class MessageBetweenRequestDto {
    private String shelfId;
    private String email;
}
