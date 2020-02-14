package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.models.Tag;

public interface ITagDao extends IQuery<Tag> {
    PhotoDao getPhotoWithMostTags();

    PhotoDao getPhotoWithLessTags();

}
