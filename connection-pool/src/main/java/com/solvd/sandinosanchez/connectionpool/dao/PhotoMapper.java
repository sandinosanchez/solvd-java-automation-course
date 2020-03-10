package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Photo;

public interface PhotoMapper extends IQuery<Photo> {

    Photo getByPostId(long id);
}
