package com.solvd.sandinosanchez.dao.interfaces;

import com.solvd.sandinosanchez.model.BaseModel;
import com.solvd.sandinosanchez.model.User;

import java.util.List;

public interface IUserDao extends IQuery<User> {
    User getByName(String name);

    List<User> getUserWithMostPosts();

}
