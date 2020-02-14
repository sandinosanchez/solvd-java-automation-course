package com.solvd.sandinosanchez.connectionpool.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Post extends BaseModel {
    private Date dateCreated;
    private String description;
    private Photo photo;
    private List<Like> likes;
    private List<Comment> comments;

    public Post() {}

    public Post(long id, Date dateCreated, String description) {
        super(id);
        this.dateCreated = dateCreated;
        this.description = description;
        this.likes = new ArrayList<>();
    }

    public Post(long id, Date date_created, String description, Photo photo) {
        super(id);
        this.dateCreated = date_created;
        this.description = description;
        this.photo = photo;
        this.comments = new ArrayList<>();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", id=" + getId() +
                '}';
    }

    public void addLike(Like like) {
        this.likes.add(like);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
