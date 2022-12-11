package com.distributedqueue.model.topic;

import com.distributedqueue.model.consumer.ISubscriber;
import com.distributedqueue.model.consumer.SubscriberWorker;
import com.distributedqueue.model.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicHandler {

    public TopicHandler(Topic topic){
        this.topic = topic;
        this.subscriberList = new ArrayList<>();
        this.subscriberWorkerMap = new HashMap<>();
    }
    private Topic topic;
    private List<ISubscriber> subscriberList;
    private Map<String, SubscriberWorker> subscriberWorkerMap;

    public void publishMessageToTopic(Message message)  {
        topic.getMessageList().add(message);
         for(ISubscriber subscriber: subscriberList){
             SubscriberWorker subscriberWorker = subscriberWorkerMap.get(subscriber.subscriberId);
             new Thread(subscriberWorker).start();
             subscriberWorker.wakeifNeeded();
         }
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<ISubscriber> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<ISubscriber> subscriberList) {
        this.subscriberList = subscriberList;
    }

    public Map<String, SubscriberWorker> getSubscriberWorkerMap() {
        return subscriberWorkerMap;
    }

    public void setSubscriberWorkerMap(Map<String, SubscriberWorker> subscriberWorkerMap) {
        this.subscriberWorkerMap = subscriberWorkerMap;
    }
}
