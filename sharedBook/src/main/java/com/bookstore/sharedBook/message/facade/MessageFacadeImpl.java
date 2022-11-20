package com.bookstore.sharedBook.message.facade;

import com.bookstore.sharedBook.message.dto.response.MessageBetweenUserResponseDto;
import com.bookstore.sharedBook.message.entity.Message;
import com.bookstore.sharedBook.message.repository.MessageRepositoryImpl;
import com.bookstore.sharedBook.user.jwt.JwtTokenProvider;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Transactional
public class MessageFacadeImpl implements MessageFacade{
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;

    private final MessageRepositoryImpl messageRepository;

    @Override
    public List<MessageBetweenUserResponseDto> getAllMessagesByShelfId(String token, String shelfId, String counterpartEmail) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        String counterpartId = userService.getUserIdFromUserEmail(counterpartEmail);
        List<Message> ret = messageRepository.findAllMessagesByShelfIdAndTwoUsers(UUID.fromString(shelfId), UUID.fromString(userId), UUID.fromString(counterpartId));
        return ret.stream().map(MessageBetweenUserResponseDto::toMessageBetweenUserResponseDto).collect(Collectors.toList());

    }

}
