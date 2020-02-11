package com.solvd.sandinosanchez.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Follower extends BaseModel {

    private Long user;
    private Long follower;
    private Date followedDate;

    public Follower(){}

    public Follower(Long id, Date followedDate) {
        super(id);
        this.followedDate = followedDate;
    }

    public static Follower initializeFollower(ResultSet rs) throws SQLException {
        return new Follower(rs.getLong("id"),
                rs.getDate("followed_date"));
    }

//    public static Follower initializeFollowers(ResultSet rs) throws SQLException {
//        followers.add(initializeFollower(rs));
//        return followers;
//    }

    public Date getFollowedDate() {
        return followedDate;
    }

    public void setFollowedDate(Date followedDate) {
        this.followedDate = followedDate;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }
}
