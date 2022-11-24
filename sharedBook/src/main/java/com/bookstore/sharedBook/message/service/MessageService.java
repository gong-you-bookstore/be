package com.bookstore.sharedBook.message.service;

import com.bookstore.sharedBook.message.dto.request.MessageRequestDto;

public interface MessageService {
    void send(String token, MessageRequestDto messageRequestDto);
    void sendRequestTransactionMessage(String token, String shelfId, String receiverEmail);
    void sendRespondTransactionMessage(String token, String shelfId, String receiverEmail);
//    List<MessageReceivedSimpleResponseDto> getAllReceivedMessages(String token);
//    List<MessageSentSimpleResponseDto> getAllSentMessages(String token);
//    MessageReceivedDetailResponseDto getReceivedMessageDetail(String token, String messageId);
//    MessageSentDetailResponseDto getSentMessageDetail(String token, String messageId);


}
