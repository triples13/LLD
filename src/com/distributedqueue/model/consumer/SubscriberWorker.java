package com.distributedqueue.model.consumer;

import com.distributedqueue.model.topic.Topic;

public class SubscriberWorker implements Runnable {

    ISubscriber subscriber;
    Topic topic;

   public SubscriberWorker(ISubscriber subscriber, Topic topic){
        this.subscriber = subscriber;
        this.topic = topic;
    }
    @Override
     public void run() {

        synchronized (this.subscriber){
            int offset = this.subscriber.offset.get();
            subscriber.receiveMessage(topic.getMessageList().get(offset));
            subscriber.getOffset().compareAndSet(offset,offset+1);
        }
     }
}
