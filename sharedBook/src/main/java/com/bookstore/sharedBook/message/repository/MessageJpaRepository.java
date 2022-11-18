package com.bookstore.sharedBook.message.repository;

import com.bookstore.sharedBook.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MessageJpaRepository extends JpaRepository<Message, UUID> {
    List<Message> findAllByReceiver(UUID receiverId);
    List<Message> findAllBySender(UUID senderId);

}
