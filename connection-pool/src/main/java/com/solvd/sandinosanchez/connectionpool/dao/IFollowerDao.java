package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.model.Follower;

import java.util.List;

public interface IFollowerDao extends IQuery<Follower> {

    List<Follower> getAllByUserId(long id);
}
