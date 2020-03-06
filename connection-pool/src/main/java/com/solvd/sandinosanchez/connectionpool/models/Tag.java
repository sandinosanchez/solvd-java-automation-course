package com.solvd.sandinosanchez.connectionpool.models;

public class Tag extends BaseModel {
    private User userTagged;

    public Tag(){}

    public Tag(Long id) {
        super(id);
    }

    public Tag(Long id, User userTagged) {
        super(id);
        this.userTagged = userTagged;
    }

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    public User getUserTagged() {
        return userTagged;
    }

    public void setUserTagged(User userTagged) {
        this.userTagged = userTagged;
    }

}
