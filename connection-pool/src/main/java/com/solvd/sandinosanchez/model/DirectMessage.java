package com.solvd.sandinosanchez.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectMessage extends BaseModel {
    private Date dateCreated;
    private Long sender;
    private Long receiver;

    public DirectMessage(){}

    public DirectMessage(Date dateCreated, Long sender, Long receiver) {
        this.dateCreated = dateCreated;
        this.sender = sender;
        this.receiver = receiver;
    }

    public DirectMessage(Long id, Date dateCreated, Long sender, Long receiver) {
        super(id);
        this.dateCreated = dateCreated;
        this.sender = sender;
        this.receiver = receiver;
    }

    public static DirectMessage initializeDirectMessage(ResultSet rs) throws SQLException {
        return new DirectMessage(rs.getLong("id"),
                rs.getDate("date_created"),
                rs.getLong("sender"),
                rs.getLong("receiver"));
    }

    public static List<DirectMessage> initializeDirectMessages(ResultSet rs) throws SQLException {
        List<DirectMessage> directMessages = new ArrayList<>();
        while (rs.next()) directMessages.add(initializeDirectMessage(rs));
        return directMessages;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }
}
