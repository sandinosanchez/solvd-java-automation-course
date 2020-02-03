package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectMessage extends BaseModel {
    private Date dateCreated;
    private User sender;
    private User receiver;

    public DirectMessage(){}

    public DirectMessage(Date dateCreated, User sender, User receiver) {
        this.dateCreated = dateCreated;
        this.sender = sender;
        this.receiver = receiver;
    }

    public DirectMessage(Long id, Date dateCreated, User sender, User receiver) {
        super(id);
        this.dateCreated = dateCreated;
        this.sender = sender;
        this.receiver = receiver;
    }
//
//    public static DirectMessage initializeDirectMessage(ResultSet rs) throws SQLException {
//        return new DirectMessage(rs.getLong("id"),
//                rs.getDate("date_created"),
//                rs.getLong("sender"),
//                rs.getLong("receiver"));
//    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
