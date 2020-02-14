package com.solvd.sandinosanchez.connectionpool.services;

import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.CommentDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.LikeDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.UserDao;
import com.solvd.sandinosanchez.connectionpool.models.Post;

public class PostService {
    private UserDao user;
    private CommentDao comment;
    private LikeDao like;

    public PostService() {
        this.user = new UserDao();
        this.comment = new CommentDao();
        this.like = new LikeDao();
    }

    public static Post initializePost() {
        // complex query here
        return null;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public CommentDao getComment() {
        return comment;
    }

    public void setComment(CommentDao comment) {
        this.comment = comment;
    }

    public LikeDao getLike() {
        return like;
    }

    public void setLike(LikeDao like) {
        this.like = like;
    }
}
