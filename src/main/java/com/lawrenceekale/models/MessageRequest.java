package com.lawrenceekale.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//please validate the variable
public class MessageRequest {
    private String content;
    private Long senderId;
    private Long recipientId;
}
