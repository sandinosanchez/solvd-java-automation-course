package com.solvd.sandinosanchez.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Post extends BaseModel {
    private Date dateCreated;
    private User user;
    private String description;
    private Photo photo;

    public Post() {}

    public Post(long id, Date dateCreated, String description, User user, Photo photo) {
        super(id);
        this.dateCreated = dateCreated;
        this.user = user;
        this.description = description;
        this.photo = photo;
    }

    public Post(long id, Date date_created, String description, Photo photo) {
        super(id);
        this.dateCreated = date_created;
        this.description = description;
        this.photo = photo;
    }

    public static Post initializePost(ResultSet rs) throws SQLException {
        return new Post(rs.getLong("id"),
                rs.getDate("date_created"),
                rs.getString("description"),
                User.initializeUser(rs, "user_id"),
                Photo.initializePhoto(rs));
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "dateCreated=" + dateCreated +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", id=" + id +
                '}';
    }
}
