package com.bookstore.sharedBook.file.entity;

import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File extends BaseEntity {
    private String name;
    @Column(columnDefinition = "BINARY(16)")
    private UUID shelfId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID uploaderId;
}
