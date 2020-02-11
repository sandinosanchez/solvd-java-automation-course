package com.solvd.sandinosanchez.dao.interfaces;

import com.solvd.sandinosanchez.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.model.Tag;

public interface ITagDao extends IQuery<Tag> {
    PhotoDao getPhotoWithMostTags();

    PhotoDao getPhotoWithLessTags();

}
