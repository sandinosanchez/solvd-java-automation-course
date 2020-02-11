package com.solvd.sandinosanchez.dao.interfaces;

import com.solvd.sandinosanchez.model.Follower;

import java.util.List;

public interface IFollowerDao extends IQuery<Follower> {

    List<Follower> getAllByUserId(long id);
}
