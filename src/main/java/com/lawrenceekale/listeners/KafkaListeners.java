package com.lawrenceekale.listeners;

import com.lawrenceekale.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "users-messages", groupId = "groupUsers")
    void listener(String data) {
        System.out.println("Listener received -> "+data);
    }
}
