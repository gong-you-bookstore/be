package com.bookstore.sharedBook.book.dto.response;

import com.bookstore.sharedBook.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.geom.Point2D;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookDetailResponseDto {
    private UUID userId;
    private String title;
    private String author;
    private String content;
    private String thumbnail;
    private String publisher;
    private String kdc;
    private Integer price;
    private Integer likeCnt;
    private String status;
    private Integer token;
    private Long latitude;
    private Long longitude;

    public static BookDetailResponseDto toBookDetailResponseDto(Book book){
        return BookDetailResponseDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .content(book.getContent())
                .thumbnail(book.getThumbnail())
                .publisher(book.getPublisher())
                .kdc(book.getKdc())
                .price(book.getPrice())
                .likeCnt(book.getLikeCnt())
                .build();
    }
}
