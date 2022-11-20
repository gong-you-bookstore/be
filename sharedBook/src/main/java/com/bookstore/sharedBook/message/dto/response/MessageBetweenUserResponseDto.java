package com.bookstore.sharedBook.message.dto.response;

import com.bookstore.sharedBook.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MessageBetweenUserResponseDto {
    private String content;
    private LocalDateTime createdAt;

    public static MessageBetweenUserResponseDto toMessageBetweenUserResponseDto(Message message){
        return MessageBetweenUserResponseDto.builder()
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .build();
    }
}
