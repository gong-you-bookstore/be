package com.bookstore.sharedBook.book.entity;
import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
public class Book extends BaseEntity {
    private Long isbn;
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;
    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String thumbnail;
    private String publisher;
    private String kdc;
    private Integer price;
    @ColumnDefault("0")
    private Integer likeCnt;
    private String status;
    @ColumnDefault("3")
    private Integer token;
    private Long latitude;
    private Long longitude;
}
