package dao;

import dao.mysqlimpl.PhotoDao;

public interface ITagDao extends IQuery {
    PhotoDao getPhotoWithMostTags();

    PhotoDao getPhotoWithLessTags();

}
