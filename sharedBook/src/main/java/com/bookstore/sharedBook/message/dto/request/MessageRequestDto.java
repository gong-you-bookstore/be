package com.bookstore.sharedBook.message.dto.request;

import lombok.Getter;

@Getter
public class MessageRequestDto {
    private String shelfId;
    private String receiverEmail;
    private String content;
}
