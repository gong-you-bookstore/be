package com.bookstore.sharedBook.message.service;

import com.bookstore.sharedBook.config.exception.CustomException;
import com.bookstore.sharedBook.message.dto.request.MessageRequestDto;
import com.bookstore.sharedBook.message.dto.response.MessageReceivedDetailResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageReceivedSimpleResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageSentDetailResponseDto;
import com.bookstore.sharedBook.message.dto.response.MessageSentSimpleResponseDto;
import com.bookstore.sharedBook.message.entity.Message;
import com.bookstore.sharedBook.message.repository.MessageRepositoryImpl;
import com.bookstore.sharedBook.user.entity.User;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bookstore.sharedBook.config.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService{
    private final JwtTokenProvider jwtTokenProvider;
    private final MessageRepositoryImpl messageRepository;
    private final UserRepositoryImpl userRepository;

    @Override
    public void send(String token, MessageRequestDto messageRequestDto) {
        String senderId = jwtTokenProvider.getUserIdFromToken(token);
        User receiver = userRepository.findUserByEmail(messageRequestDto.getReceiverEmail()).orElseThrow(()->new CustomException(RECEIVER_NOT_FOUND));

        Message message = Message.builder()
                .shelfId(UUID.fromString(messageRequestDto.getShelfId()))
                .sender(UUID.fromString(senderId))
                .receiver(receiver.getId())
                .content(messageRequestDto.getContent())
                .build();

        messageRepository.save(message);
    }

    @Override
    public List<MessageReceivedSimpleResponseDto> getAllReceivedMessages(String token) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        List<MessageReceivedSimpleResponseDto> res = new ArrayList<>();
        List<Message> messages = messageRepository.findAllByReceiverId(UUID.fromString(userId));
        for(Message message : messages){
            String senderEmail = userRepository.findUserEmail(message.getSender());
            res.add(MessageReceivedSimpleResponseDto.toMessageSimpleResponseDto(message.getId().toString(), senderEmail));
        }
        return res;
    }

    @Override
    public List<MessageSentSimpleResponseDto> getAllSentMessages(String token) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        List<MessageSentSimpleResponseDto> res = new ArrayList<>();
        List<Message> messages = messageRepository.findAllBySenderId(UUID.fromString(userId));
        for(Message message : messages){
            String receiverEmail = userRepository.findUserEmail(message.getReceiver());
            res.add(MessageSentSimpleResponseDto.toMessageSimpleResponseDto(message.getId().toString(), receiverEmail));
        }
        return res;
    }

    @Override
    public MessageReceivedDetailResponseDto getReceivedMessageDetail(String token, String messageId) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        Message message = messageRepository.findById(UUID.fromString(messageId)).orElseThrow(()-> new CustomException(MESSAGE_NOT_FOUND));
        String senderEmail = userRepository.findUserEmail(message.getSender());
        return MessageReceivedDetailResponseDto.toMessageDetailResponseDto(message, senderEmail);
    }

    @Override
    public MessageSentDetailResponseDto getSentMessageDetail(String token, String messageId) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        Message message = messageRepository.findById(UUID.fromString(messageId)).orElseThrow(()-> new CustomException(MESSAGE_NOT_FOUND));
        String receiverEmail = userRepository.findUserEmail(message.getReceiver());
        return MessageSentDetailResponseDto.toMessageDetailResponseDto(message, receiverEmail);
    }



}
