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

        synchronized (this.subscriber) {
            do {
                int offset = this.subscriber.offset.get();

                if (offset >= topic.getMessageList().size()) {
                    try {
                        this.subscriber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(offset<topic.getMessageList().size()) {
                    subscriber.receiveMessage(topic.getMessageList().get(offset));
                    subscriber.getOffset().compareAndSet(offset, offset + 1);
                }
            }
            while (true);
        }
     }

     public synchronized void wakeifNeeded(){
       synchronized (this.subscriber){
           this.subscriber.notify();
       }
     }
}
