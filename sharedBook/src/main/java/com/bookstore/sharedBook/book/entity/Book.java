package com.bookstore.sharedBook.book.entity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
public class Book {
    @Id
    private Long isbn;
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
}
