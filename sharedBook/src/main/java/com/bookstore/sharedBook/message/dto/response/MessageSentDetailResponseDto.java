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
public class MessageSentDetailResponseDto {
    private String messageId;
    private String receiverEmail;
    private String content;

    public static MessageSentDetailResponseDto toMessageDetailResponseDto(Message message, String receiverEmail){
        return MessageSentDetailResponseDto.builder()
                .messageId(message.getId().toString())
                .receiverEmail(receiverEmail)
                .content(message.getContent())
                .build();
    }
}
