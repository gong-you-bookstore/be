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
public class MessageReceivedSimpleResponseDto {
    private String messageId;
    private String senderEmail;

    public static MessageReceivedSimpleResponseDto toMessageSimpleResponseDto(String messageId, String senderEmail){
        return MessageReceivedSimpleResponseDto.builder()
                .messageId(messageId)
                .senderEmail(senderEmail)
                .build();

    }
}
