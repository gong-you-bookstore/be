package com.bookstore.sharedBook.survey.entity;

import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;
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
public class Interest extends BaseEntity {
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;
    private Integer genre;
}
