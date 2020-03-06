package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Comment;

import java.util.List;

public interface ICommentDao extends IQuery<Comment> {

    List<Comment> getCommentsByPostId(long id);

}
