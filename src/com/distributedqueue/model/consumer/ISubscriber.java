package com.distributedqueue.model.consumer;

import com.distributedqueue.model.message.Message;
import com.distributedqueue.model.topic.Topic;

public abstract class ISubscriber {

    public String subscriberId;
    public abstract void receiveMessage(Message message);

    public ISubscriber(String subscriberId){
        this.subscriberId = subscriberId;
    }
}
