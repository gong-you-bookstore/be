package com.bookstore.sharedBook.message.facade;

import com.bookstore.sharedBook.message.dto.response.MessageBetweenUserResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageBoxResponseDto;

import java.util.List;

public interface MessageFacade {
    List<MessageBetweenUserResponseDto> getAllMessagesByShelfId(String token, String shelfId, String email1, String email2);
    List<MessageBoxResponseDto> getAllMyMessages(String token);
}
