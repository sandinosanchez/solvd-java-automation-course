package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Comment;

import java.util.List;

public interface ICommentDao extends IQuery<Comment> {

<<<<<<< HEAD
    List<Comment> getCommentsByPostId(long id);
=======
    List<Comment> getAllByPostId(long id);
>>>>>>> 6f2746a38ec765cca33fc53e5f24be71c90be632

}
