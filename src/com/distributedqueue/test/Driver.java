package com.distributedqueue.test;

import com.distributedqueue.model.consumer.Subscriber;
import com.distributedqueue.model.message.Message;
import com.distributedqueue.model.queue.Queue;
import com.distributedqueue.service.QueueService;

public class Driver {

    public static void main(String [] args) {

        Queue queue = new Queue();
        QueueService queueService = new QueueService(queue);
        queueService.createTopic("topic-1");
        queueService.createTopic("topic-2");
        queueService.createTopic("topic-3");

        queueService.addSubscription("topic-1",new Subscriber("subscriber-1"));
        queueService.addSubscription("topic-1",new Subscriber("subscriber-2"));
        queueService.addSubscription("topic-1",new Subscriber("subscriber-3"));


        queueService.addSubscription("topic-2",new Subscriber("subscriber-4"));
        queueService.addSubscription("topic-2",new Subscriber("subscriber-5"));


        queueService.addSubscription("topic-3",new Subscriber("subscriber-6"));
        queueService.addSubscription("topic-3",new Subscriber("subscriber-7"));
        queueService.addSubscription("topic-3",new Subscriber("subscriber-8"));
        queueService.addSubscription("topic-3",new Subscriber("subscriber-9"));

        queueService.publish("topic-1",new Message("first message"));
        queueService.publish("topic-1",new Message("second messsage"));
        queueService.publish("topic-1",new Message("third message"));
        queueService.publish("topic-1",new Message("fourth messsage"));
        queueService.publish("topic-1",new Message("fifth messsage"));
    }
}
