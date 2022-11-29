package com.bookstore.sharedBook.message.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MessageRequestDto {
    @NotEmpty(message = "shelfId에 null값을 넣을 수 없습니다.")
    private String shelfId;
    private String receiverEmail;
    private String content;
}
