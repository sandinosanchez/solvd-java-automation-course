package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@XmlRootElement(name = "follower")
public class Follower extends BaseModel {

    @JsonProperty("Follower")
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

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

}
