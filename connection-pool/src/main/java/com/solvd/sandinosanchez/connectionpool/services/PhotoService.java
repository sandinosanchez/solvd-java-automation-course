package com.solvd.sandinosanchez.connectionpool.services;

import com.solvd.sandinosanchez.connectionpool.dao.PhotoMapper;
import com.solvd.sandinosanchez.connectionpool.dao.TagMapper;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.TagDao;
import com.solvd.sandinosanchez.connectionpool.models.Photo;

public class PhotoService {
    private PhotoMapper photoDao;
    private TagMapper tagDao;

    private PhotoService(PhotoMapper photoDao, TagMapper tagDao) {
        this.tagDao = tagDao;
        this.photoDao = photoDao;
    }

    public PhotoService() {
        this.photoDao = new PhotoDao();
        this.tagDao = new TagDao();
    }

    public Photo getById(long id) {
        Photo photo = photoDao.getById(id);
        //photo.setTags(photoDao.getAllByPhotoId(photo.getId()));
        return photo;
    }

    public PhotoMapper getPhotoDao() {
        return photoDao;
    }

    public void setPhotoDao(PhotoMapper photoDao) {
        this.photoDao = photoDao;
    }

    public TagMapper getTagDao() {
        return tagDao;
    }

    public void setTagDao(TagMapper tagDao) {
        this.tagDao = tagDao;
    }
}
