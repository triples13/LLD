package com.distributedqueue.model.topic;

import com.distributedqueue.model.consumer.ISubscriber;
import com.distributedqueue.model.message.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class TopicHandler {

    public TopicHandler(Topic topic){
        this.topic = topic;
        this.subscriberList = new ArrayList<>();
    }
    private Topic topic;
    private List<ISubscriber> subscriberList;

    public void publishMessageToTopic(Message message){
         for(ISubscriber subscriber: subscriberList){
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             new Thread(()->subscriber.receiveMessage(message)).start();
         }
    }



}
