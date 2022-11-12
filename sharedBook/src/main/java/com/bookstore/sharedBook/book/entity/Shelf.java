package com.bookstore.sharedBook.book.entity;

import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
public class Shelf extends BaseEntity {
    private Long isbn;
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;
    private String status;
    @ColumnDefault("3")
    private Integer token;
    private Long latitude;
    private Long longitude;
}
