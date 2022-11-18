package com.bookstore.sharedBook.message.entity;

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
public class Message extends BaseEntity {
    @Column(columnDefinition = "BINARY(16)")
    private UUID sender;
    @Column(columnDefinition = "BINARY(16)")
    private UUID receiver;
    private boolean opened;
    @Column(columnDefinition = "TEXT")
    private String content;
}
