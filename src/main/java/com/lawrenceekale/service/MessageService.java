package com.lawrenceekale.service;

import com.lawrenceekale.Message;
import com.lawrenceekale.models.MessageRequest;
import com.lawrenceekale.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MessageService {
    @Autowired
    private  KafkaTemplate<String, Message> kafkaTemplate;
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(MessageRequest message) {
        Message messageToPersist = Message.builder()
                .isRead(false)
                .content(message.getContent())
                .senderId(message.getSenderId())
                .recipientId(message.getRecipientId())
                .time(new Timestamp(System.currentTimeMillis()))
                .build();

        messageRepository.save(messageToPersist);

        Long messageId = messageToPersist.getMessageId();
        messageToPersist.setMessageId(messageId);

        kafkaTemplate.send("users-messages",messageToPersist);
    }
}
