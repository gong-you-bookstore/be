package com.bookstore.sharedBook.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShelfStatus {
    UNSOLD("UNSOLD"),
    PENDING("PENDING"),
    SOLD("SOLD"),
    READ("READ");

    private final String state;
}
