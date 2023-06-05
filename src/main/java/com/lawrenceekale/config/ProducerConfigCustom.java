package com.lawrenceekale.config;

import org.springframework.kafka.support.serializer.JsonSerializer;
import com.lawrenceekale.Message;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import  org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfigCustom {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapKafkaServer;

    public Map<String, Object> producerConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapKafkaServer);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return map;
    }

    @Bean
    public ProducerFactory<String, Message> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,Message> kafkaTemplate(ProducerFactory<String, Message> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}

