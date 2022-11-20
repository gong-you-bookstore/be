package com.bookstore.sharedBook.message.repository;

import com.bookstore.sharedBook.message.entity.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {
    void save(Message message);
    List<Message> findAllByReceiverId(UUID receiverId);
    List<Message> findAllBySenderId(UUID senderId);
    Optional<Message> findById(UUID messageId);

    List<Message> findAllMessagesByShelfIdAndTwoUsers(UUID shelfId, UUID userId, UUID counterpartId);
}
