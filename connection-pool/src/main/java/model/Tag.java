package model;

import dao.mysqlimpl.PhotoDao;
import dao.mysqlimpl.UserDao;

public class Tag extends BaseModel {
    private UserDao userTagged;
    private PhotoDao photo;

    public Tag(){}

    public Tag(Long id, UserDao userTagged, PhotoDao photo) {
        super(id);
        this.userTagged = userTagged;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDao getUserTagged() {
        return userTagged;
    }

    public void setUserTagged(UserDao userTagged) {
        this.userTagged = userTagged;
    }

    public PhotoDao getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDao photo) {
        this.photo = photo;
    }
}
