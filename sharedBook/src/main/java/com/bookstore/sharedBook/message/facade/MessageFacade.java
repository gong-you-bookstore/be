package com.bookstore.sharedBook.message.facade;

import com.bookstore.sharedBook.message.dto.response.MessageBetweenUserResponseDto;

import java.util.List;

public interface MessageFacade {
    List<MessageBetweenUserResponseDto> getAllMessagesByShelfId(String token, String shelfId, String counterpartEmail);

}
