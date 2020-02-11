package com.solvd.sandinosanchez.dao.interfaces;

import com.solvd.sandinosanchez.model.Post;

public interface IPostDao extends IQuery<Post> {

    Post getMostLikedPostById(long id);

    Post getMostLikedPostByFirstName(String firstName);

    Post getMostCommentedPost();

}
