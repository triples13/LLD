package com.distributedqueue.service;

import com.distributedqueue.model.consumer.ISubscriber;
import com.distributedqueue.model.message.Message;
import com.distributedqueue.model.queue.Queue;
import com.distributedqueue.model.topic.Topic;
import com.distributedqueue.model.topic.TopicHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class QueueService {

    private final Queue queue;
    private Map<String, Topic> topicMap;
    private Map<Topic, TopicHandler> topicHandlerMap;

    public QueueService(Queue queue){
        this.queue = queue;
        this.topicMap = new HashMap<>();
        this.topicHandlerMap = new HashMap<>();
    }

    public void createTopic (String topicName){
        Topic topic = new Topic(topicName, new ArrayList<>());
        TopicHandler topicHandler = new TopicHandler(topic);
        this.topicMap.put(topicName,topic);
        this.topicHandlerMap.put(topic, topicHandler);
        this.queue.createTopic(topic);
    }

    public void addSubscription (String topicName, ISubscriber iSubscriber){
        var topic =  topicMap.get(topicName);
        var topicHandler = topicHandlerMap.get(topic);
        topicHandler.getSubscriberList().add(iSubscriber);
    }

    public void publish(String topicName, Message message){
        var topic =  topicMap.get(topicName);
        topic.getMessageList().add(message);
        var topicHandler = topicHandlerMap.get(topic);
        System.out.println("message :"+ message.getMessage()+ " published to topic: " + topic.getTopicName());
        topicHandler.publishMessageToTopic(message);
    }
}
