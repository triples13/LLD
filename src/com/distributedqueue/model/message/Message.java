package com.distributedqueue.model.message;





public class Message {
    public final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
