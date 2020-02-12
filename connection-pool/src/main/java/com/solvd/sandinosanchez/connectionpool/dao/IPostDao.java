package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.model.Post;

import java.util.List;

public interface IPostDao extends IQuery<Post> {

    Post getMostLikedPostById(long id);

    Post getMostLikedPostByFirstName(String firstName);

    Post getMostCommentedPost();

    List<Post> getAllByUserId(long id);

}
