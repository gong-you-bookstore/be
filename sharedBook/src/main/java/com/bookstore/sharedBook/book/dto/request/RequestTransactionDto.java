package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;

@Getter
public class RequestTransactionDto {
    private String shelfId;
    private String receiverEmail;
}
