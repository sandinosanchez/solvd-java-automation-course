package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Post;

import java.util.List;

public interface PostMapper extends IQuery<Post> {

    Post getMostCommentedPost();

}
