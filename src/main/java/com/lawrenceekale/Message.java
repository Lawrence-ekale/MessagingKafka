package com.lawrenceekale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Long messageId;
    private String content;
    private Long senderId;
    private Long recipientId;
    private Timestamp time;
    private Boolean isRead;
}
