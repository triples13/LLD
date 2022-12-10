package com.distributedqueue.model.consumer;

import com.distributedqueue.model.message.Message;

import java.util.concurrent.atomic.AtomicInteger;

public class Subscriber extends ISubscriber{

    public Subscriber(String subscriberId) {
        super(subscriberId);
        this.offset = new AtomicInteger(0);
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println("received message: " + message.getMessage() +" by consumer: "+ subscriberId);
    }
}
