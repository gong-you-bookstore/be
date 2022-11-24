package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;

@Getter
public class RespondTransactionDto {
    private String shelfId;
    private String receiverEmail;
}
