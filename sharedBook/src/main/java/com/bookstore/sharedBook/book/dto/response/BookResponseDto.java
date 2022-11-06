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
public class BookResponseDto {
    private UUID userId;
    private String kdc;
    private String thumbnail;

    public static BookResponseDto toBookResponseDto(Book book){
        return BookResponseDto.builder()
                .userId(book.getUserId())
                .kdc(book.getKdc())
                .thumbnail(book.getThumbnail())
                .build();
    }
}
