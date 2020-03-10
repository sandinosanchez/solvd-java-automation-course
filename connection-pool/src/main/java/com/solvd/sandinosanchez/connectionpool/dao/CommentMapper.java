package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Comment;

import java.util.List;

public interface CommentMapper extends IQuery<Comment> {

    List<Comment> getAllByPostId(long id);

}
