package com.distributedqueue.model.consumer;

import com.distributedqueue.model.message.Message;

public class Subscriber extends ISubscriber{

    public Subscriber(String subscriberId) {
        super(subscriberId);
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println("received message: " + message.getMessage() +" by consumer: "+ subscriberId);
    }
}
