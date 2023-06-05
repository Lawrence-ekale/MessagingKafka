package com.lawrenceekale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class MessagingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String,Message> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("users-messages",Message.builder()
							.messageId(143L)
							.content("Hello there")
							.recipientId(234L)
							.senderId(122L)
							.time(new Timestamp(System.currentTimeMillis()))
							.isRead(false)
					.build());
		};
	}

}
