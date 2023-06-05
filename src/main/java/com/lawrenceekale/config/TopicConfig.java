package com.lawrenceekale.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic createUsersTopic() {
        return TopicBuilder.name("users-messages")
                .build();
    }

    @Bean
    public NewTopic createSystemTopic() {
        return TopicBuilder.name("systems-messages")
                .build();
    }
}
