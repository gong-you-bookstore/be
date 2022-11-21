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
public class MessageBoxResponseDto {
    private String shelfId;
    private String myEmail;
    private String counterpartEmail;

    public static MessageBoxResponseDto toMessageBoxResponseDto(Message message, String myEmail, String counterpartEmail){
        return MessageBoxResponseDto.builder()
                .shelfId(message.getShelfId().toString())
                .myEmail(myEmail)
                .counterpartEmail(counterpartEmail)
                .build();
    }
}
