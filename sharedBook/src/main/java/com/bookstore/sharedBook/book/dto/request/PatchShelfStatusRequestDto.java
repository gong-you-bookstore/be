package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;

@Getter
public class PatchShelfStatusRequestDto {
    private String shelfId;
    private String request;
}
