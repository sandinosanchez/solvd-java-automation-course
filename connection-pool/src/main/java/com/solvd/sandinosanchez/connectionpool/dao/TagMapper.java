package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.models.Tag;

import java.util.List;

public interface TagMapper extends IQuery<Tag> {
    PhotoDao getPhotoWithMostTags();

    PhotoDao getPhotoWithLessTags();

    List<Tag> getAllByPhotoId(long id);

}
