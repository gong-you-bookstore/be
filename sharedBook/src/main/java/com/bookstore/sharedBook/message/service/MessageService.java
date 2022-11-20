package com.bookstore.sharedBook.message.service;

import com.bookstore.sharedBook.message.dto.request.MessageRequestDto;
import com.bookstore.sharedBook.message.dto.response.MessageReceivedDetailResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageReceivedSimpleResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageSentDetailResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageSentSimpleResponseDto;
import com.bookstore.sharedBook.message.entity.Message;

import java.util.List;

public interface MessageService {
    void send(String token, MessageRequestDto messageRequestDto);
    List<MessageReceivedSimpleResponseDto> getAllReceivedMessages(String token);
    List<MessageSentSimpleResponseDto> getAllSentMessages(String token);
    MessageReceivedDetailResponseDto getReceivedMessageDetail(String token, String messageId);
    MessageSentDetailResponseDto getSentMessageDetail(String token, String messageId);


}
