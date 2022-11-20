package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class ShelfDetailRequestDto {
    private Long isbn;
    private String userId;
}
