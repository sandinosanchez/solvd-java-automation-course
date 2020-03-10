package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Like;

import java.util.List;

public interface LikeMapper extends IQuery<Like> {

    List<Like> getAllByPostId(long id);

}
