package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Like extends BaseModel {
    @JsonProperty("User")
    private User user;

    @JsonProperty("DateLiked")
    private Date dateLiked;

    public Like(){}

    public Like(Date dateLiked) {
        this.user = new User();
        this.dateLiked = dateLiked;
    }

    public Like(Long id, Date dateLiked) {
        super(id);
        this.user = new User();
        this.dateLiked = dateLiked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateLiked() {
        return dateLiked;
    }

    public void setDateLiked(Date dateLiked) {
        this.dateLiked = dateLiked;
    }

    @Override
    public String toString() {
        return "Like{" +
                "user=" + user.getFirstName() +
                ", dateLiked=" + dateLiked +
                '}';
    }
}
