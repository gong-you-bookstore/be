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
public class MessageReceivedDetailResponseDto{
    private String messageId;
    private String senderEmail;
    private String content;

    public static MessageReceivedDetailResponseDto toMessageDetailResponseDto(Message message, String senderEmail){
        return MessageReceivedDetailResponseDto.builder()
                .messageId(message.getId().toString())
                .senderEmail(senderEmail)
                .content(message.getContent())
                .build();
    }
}
