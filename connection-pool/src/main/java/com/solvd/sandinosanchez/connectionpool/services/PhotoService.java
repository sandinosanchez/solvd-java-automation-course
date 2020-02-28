package com.solvd.sandinosanchez.connectionpool.services;

import com.solvd.sandinosanchez.connectionpool.dao.IPhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.ITagDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.TagDao;
import com.solvd.sandinosanchez.connectionpool.models.Photo;

public class PhotoService {
    private IPhotoDao photoDao;
    private ITagDao tagDao;

    private PhotoService( IPhotoDao photoDao, ITagDao tagDao) {
        this.tagDao = tagDao;
        this.photoDao = photoDao;
    }

    public PhotoService() {
        this.photoDao = new PhotoDao();
        this.tagDao = new TagDao();
    }

    public Photo getById(long id) {
        Photo photo = photoDao.getById(id);
        photo.setTags(tagDao.getAllByPhotoId(photo.getId()));
        return photo;
    }

    public IPhotoDao getPhotoDao() {
        return photoDao;
    }

    public void setPhotoDao(IPhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    public ITagDao getTagDao() {
        return tagDao;
    }

    public void setTagDao(ITagDao tagDao) {
        this.tagDao = tagDao;
    }
}
