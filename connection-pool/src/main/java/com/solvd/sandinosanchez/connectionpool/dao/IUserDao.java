package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.model.User;

import java.util.List;

public interface IUserDao extends IQuery<User> {
    User getByName(String name);

    List<User> getUserWithMostPosts();

}
