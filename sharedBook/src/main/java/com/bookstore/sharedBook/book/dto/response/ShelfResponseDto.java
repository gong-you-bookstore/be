package com.bookstore.sharedBook.book.dto.response;

import com.bookstore.sharedBook.book.entity.Shelf;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ShelfResponseDto {
    private Long isbn;
    private UUID userId;

    public static ShelfResponseDto toShelfResponseDto(Shelf shelf){
        return ShelfResponseDto.builder()
                .isbn(shelf.getIsbn())
                .userId(shelf.getUserId())
                .build();
    }
}
