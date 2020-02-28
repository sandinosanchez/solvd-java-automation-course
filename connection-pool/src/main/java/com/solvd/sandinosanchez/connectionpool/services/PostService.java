package com.solvd.sandinosanchez.connectionpool.services;

import com.solvd.sandinosanchez.connectionpool.dao.*;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.CommentDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.LikeDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PostDao;
import com.solvd.sandinosanchez.connectionpool.models.Like;
import com.solvd.sandinosanchez.connectionpool.models.Photo;
import com.solvd.sandinosanchez.connectionpool.models.Post;

import java.util.List;

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

    public Post getById(long id) {
        Post post = postDao.getById(id);
        post.setLikes(likeDao.getAllByPostId(post.getId()));
        post.setComments(commentDao.getAllByPostId(post.getId()));
        return post;
    }

    public List<Post> getAll() {
        List<Post> posts = postDao.getAll();
        posts.forEach(this::initializePost);
        return posts;
    }

    private void initializePost(Post post) {
        post.setLikes(likeDao.getAllByPostId(post.getId()));
        post.setComments(commentDao.getAllByPostId(post.getId()));
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
