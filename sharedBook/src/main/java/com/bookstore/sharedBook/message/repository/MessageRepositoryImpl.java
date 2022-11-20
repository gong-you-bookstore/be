package com.bookstore.sharedBook.message.repository;

import com.bookstore.sharedBook.message.entity.Message;
import com.bookstore.sharedBook.message.entity.QMessage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImpl implements MessageRepository{
    private final MessageJpaRepository messageJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QMessage message = QMessage.message;

    @Override
    public void save(Message message) {
        messageJpaRepository.save(message);
    }

    @Override
    public List<Message> findAllByReceiverId(UUID receiverId) {
        return messageJpaRepository.findAllByReceiver(receiverId);
    }

    @Override
    public List<Message> findAllBySenderId(UUID senderId) {
        return messageJpaRepository.findAllBySender(senderId);
    }

    @Override
    public Optional<Message> findById(UUID messageId) {
        return messageJpaRepository.findById(messageId);
    }

    @Override
    public List<Message> findAllMessagesByShelfIdAndTwoUsers(UUID shelfId, UUID userId, UUID counterpartId) {
        return jpaQueryFactory
                .selectFrom(message)
                .where(message.shelfId.eq(shelfId).and(message.sender.eq(userId)).and(message.receiver.eq(counterpartId))
                        .or((message.shelfId.eq(shelfId)).and(message.sender.eq(counterpartId)).and(message.receiver.eq(userId))))
                .orderBy(message.createdAt.asc())
                .fetch();
    }

}
