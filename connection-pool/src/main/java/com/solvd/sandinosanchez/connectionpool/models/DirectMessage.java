package com.solvd.sandinosanchez.connectionpool.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DirectMessage extends BaseModel {
    private Date dateCreated;
    private User receiver;
    private List<Message> messages;

    public DirectMessage(){}

    public DirectMessage(Date dateCreated, User receiver) {
        this.dateCreated = dateCreated;
        this.receiver = receiver;
        this.messages = new ArrayList<>();
    }

    public DirectMessage(Long id, Date dateCreated) {
        super(id);
        this.dateCreated = dateCreated;
        this.receiver = new User();
        this.messages = new ArrayList<>();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
