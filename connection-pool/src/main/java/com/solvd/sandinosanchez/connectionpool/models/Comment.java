package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comment")
public class Comment extends BaseModel {
    @JsonProperty("Comment")
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
