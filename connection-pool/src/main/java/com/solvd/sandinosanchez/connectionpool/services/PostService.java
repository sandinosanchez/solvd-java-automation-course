package com.solvd.sandinosanchez.connectionpool.services;

import com.solvd.sandinosanchez.connectionpool.dao.*;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.CommentDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.LikeDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PostDao;
import com.solvd.sandinosanchez.connectionpool.models.Photo;
import com.solvd.sandinosanchez.connectionpool.models.Post;

public class PostService {
    private IPostDao postDao;
    private ICommentDao commentDao;
    private ILikeDao likeDao;
    private IPhotoDao photoDao;

    public PostService() {
        this.commentDao = new CommentDao();
        this.likeDao = new LikeDao();
        this.postDao = new PostDao();
        this.photoDao = new PhotoDao();
    }

    public Post getPost(long id) {
        Post post = postDao.getById(id);
        return null;
    }

    public ICommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public ILikeDao getLikeDao() {
        return likeDao;
    }

    public void setLikeDao(LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    public IPostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(IPostDao postDao) {
        this.postDao = postDao;
    }

    public IPhotoDao getPhotoDao() {
        return photoDao;
    }

    public void setPhotoDao(IPhotoDao photoDao) {
        this.photoDao = photoDao;
    }
}
