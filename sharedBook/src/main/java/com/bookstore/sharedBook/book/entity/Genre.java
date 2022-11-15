package com.bookstore.sharedBook.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    TOTAL("총류", 0),
    PHILOSOPHY("철학", 100),
    RELIGION("종교", 200),
    SOCIAL_SCIENCE("사회과학", 300),
    PURE_SCIENCE("순수과학", 400),
    TECH_SCIENCE("기술과학", 500),
    ART("예술", 600),
    LANGUAGE("언어", 700),
    LITERATURE("문학", 800),
    HISTORY("역사", 900);

    private final String type;
    private final Integer kdc;
}
