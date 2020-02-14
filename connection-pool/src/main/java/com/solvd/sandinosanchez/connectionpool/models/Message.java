package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Message extends BaseModel {
    @JsonProperty("Message")
    private String message;

    @JsonProperty("DateCreated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
