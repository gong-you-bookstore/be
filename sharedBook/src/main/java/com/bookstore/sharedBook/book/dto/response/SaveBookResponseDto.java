package com.bookstore.sharedBook.book.dto.response;

import com.bookstore.sharedBook.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SaveBookResponseDto {
    private String title;

    public static SaveBookResponseDto toSaveResponseDto(Book book){
        return SaveBookResponseDto.builder()
                .title(book.getTitle())
                .build();
    }
}
