package com.distributedqueue.model.consumer;

import com.distributedqueue.model.message.Message;
import com.distributedqueue.model.topic.Topic;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ISubscriber {

    public String subscriberId;
    public AtomicInteger offset;
    public abstract void receiveMessage(Message message);

    public ISubscriber(String subscriberId){
        this.subscriberId = subscriberId;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }
}
