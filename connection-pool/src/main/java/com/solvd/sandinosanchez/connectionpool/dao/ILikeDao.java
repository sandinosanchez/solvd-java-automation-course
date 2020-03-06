package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Like;

import java.util.List;

public interface ILikeDao extends IQuery<Like> {

    List<Like> getLikesByPostId(long id);

}
