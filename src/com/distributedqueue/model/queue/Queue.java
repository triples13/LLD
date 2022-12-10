package com.distributedqueue.model.queue;

import com.distributedqueue.model.topic.Topic;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Topic> topicList;

    public Queue(){
        topicList = new ArrayList<>();
    }

    public void createTopic(Topic topic){
        this.topicList.add(topic);
    }


}
