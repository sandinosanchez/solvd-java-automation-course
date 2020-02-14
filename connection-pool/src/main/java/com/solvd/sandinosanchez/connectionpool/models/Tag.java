package com.solvd.sandinosanchez.connectionpool.models;

import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PhotoDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.UserDao;

public class Tag extends BaseModel {
    private UserDao userTagged;

    public Tag(){}

    public Tag(Long id) {
        super(id);
    }

    public Tag(Long id, UserDao userTagged) {
        super(id);
        this.userTagged = userTagged;
    }

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    public UserDao getUserTagged() {
        return userTagged;
    }

    public void setUserTagged(UserDao userTagged) {
        this.userTagged = userTagged;
    }

}
