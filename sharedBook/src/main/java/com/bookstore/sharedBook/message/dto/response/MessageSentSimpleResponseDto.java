package com.bookstore.sharedBook.message.dto.response;

import com.bookstore.sharedBook.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MessageSentSimpleResponseDto {
    private String messageId;
    private String receiverEmail;

    public static MessageSentSimpleResponseDto toMessageSimpleResponseDto(String messageId, String receiverEmail){
        return MessageSentSimpleResponseDto.builder()
                .messageId(messageId)
                .receiverEmail(receiverEmail)
                .build();

    }
}
