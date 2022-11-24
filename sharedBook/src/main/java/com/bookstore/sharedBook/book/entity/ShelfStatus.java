package com.bookstore.sharedBook.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookStatus {
    UNSOLD("UNSOLD"),
    SOLD("SOLD"),
    READ("READ");

    private final String state;
}
