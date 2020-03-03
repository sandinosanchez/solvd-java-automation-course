package com.solvd.sandinosanchez.connectionpool.models;

import java.sql.Date;

public class Follower extends BaseModel {

    private User user;
    private User follower;
    private Date followedDate;

    public Follower(){}

    public Follower(Long id, Date followedDate) {
        super(id);
        this.followedDate = followedDate;
    }

    public Date getFollowedDate() {
        return followedDate;
    }

    public void setFollowedDate(Date followedDate) {
        this.followedDate = followedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
