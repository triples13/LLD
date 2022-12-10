package com.distributedqueue.model.topic;

import com.distributedqueue.model.message.Message;

import java.util.List;

public class Topic {

    private final String topicName;
    private final List<Message> messageList;

    public Topic(String topicName, List<Message> messageList) {
        this.topicName = topicName;
        this.messageList = messageList;
    }

    public String getTopicName() {
        return topicName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
