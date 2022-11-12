package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;

import java.awt.geom.Point2D;
import java.util.List;

@Getter
public class SaveBookRequestDto {
    private Long isbn;
    private String title;
    private List<String> author;
    private String content;
    private String thumbnail;
    private String publisher;
    private String kdc;
    private Integer price;
    private String status;
    private Integer token;
    private Long latitude;
    private Long longitude;
}
