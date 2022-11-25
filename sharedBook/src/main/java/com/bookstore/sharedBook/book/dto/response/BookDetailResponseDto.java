package com.bookstore.sharedBook.book.dto.response;

import com.bookstore.sharedBook.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookDetailResponseDto {
    private Long isbn;
    private String title;
    private String author;
    private String content;
    private String thumbnail;
    private String publisher;
    private String kdc;
    private Integer price;
    private Integer likeCnt;
    private List<String> userList;

    public static BookDetailResponseDto toBookDetailResponseDto(Book book, List<String> userList){
        return BookDetailResponseDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .content(book.getContent())
                .thumbnail(book.getThumbnail())
                .publisher(book.getPublisher())
                .kdc(book.getKdc())
                .price(book.getPrice())
                .likeCnt(book.getLikeCnt())
                .userList(userList)
                .build();
    }
}
