package com.distributedqueue.model.topic;

import com.distributedqueue.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class Topic {

    private final String topicName;
    private final List<Message> messageList;
}
