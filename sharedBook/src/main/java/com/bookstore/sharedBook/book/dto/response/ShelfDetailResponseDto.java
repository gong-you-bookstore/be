package com.bookstore.sharedBook.book.dto.response;

import com.bookstore.sharedBook.book.entity.Shelf;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ShelfDetailResponseDto {
    private Long isbn;
    private UUID userId;
    private String status;
    private Integer token;
    private Long latitude;
    private Long longitude;
    private List<String> images;

    public static ShelfDetailResponseDto toShelfResponseDto(Shelf shelf, List<String> images){
        return ShelfDetailResponseDto.builder()
                .isbn(shelf.getIsbn())
                .userId(shelf.getUserId())
                .status(shelf.getStatus())
                .token(shelf.getToken())
                .latitude(shelf.getLatitude())
                .longitude(shelf.getLongitude())
                .images(images)
                .build();
    }
}
