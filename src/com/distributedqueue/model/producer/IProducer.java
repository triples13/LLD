package com.distributedqueue.model.producer;

import com.distributedqueue.model.message.Message;
import com.distributedqueue.model.topic.Topic;

public interface IProducer {

    public void publish(Topic topic, Message message);
}
