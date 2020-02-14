package com.solvd.sandinosanchez.connectionpool.models;

import java.sql.Date;

public class Message extends BaseModel {
    private String message;
    private Date dateCreated;

    public Message(){}

    public Message(String message, Date dateCreated) {
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public Message(Long id, String message, Date dateCreated) {
        super(id);
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}
