package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Post")
public class Post extends BaseModel {
    @JsonProperty("DateCreated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;
    private String description;
    private User user;
    private Photo photo;
    private List<Like> likes;
    private List<Comment> comments;

    public Post() {}

    public Post(long id, Date dateCreated, String description) {
        super(id);
        this.dateCreated = dateCreated;
        this.description = description;
        this.user = new User();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Post(long id, Date dateCreated, String description, Photo photo, User user) {
        super(id);
        this.user = user;
        this.dateCreated = dateCreated;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
