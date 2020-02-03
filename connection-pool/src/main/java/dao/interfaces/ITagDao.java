package dao.interfaces;

import dao.mysqlimpl.PhotoDao;
import model.Tag;

public interface ITagDao extends IQuery<Tag> {
    PhotoDao getPhotoWithMostTags();

    PhotoDao getPhotoWithLessTags();

}
