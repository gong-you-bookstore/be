package com.bookstore.sharedBook.book.dto.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
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
    private BigDecimal latitude;
    private BigDecimal longitude;
}
