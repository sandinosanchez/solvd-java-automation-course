package com.solvd.sandinosanchez.connectionpool.models;

public class Comment extends BaseModel {
    private String comment;

    public Comment(){}

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(Long id, String comment) {
        super(id);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
