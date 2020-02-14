package com.solvd.sandinosanchez.connectionpool.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Photo extends BaseModel {
    private String url;
    private List<Tag> tags;

    public Photo() {}

    public Photo(String url) {
        this.url = url;
    }

    public Photo(Long id, String url) {
        super(id);
        this.url = url;
        this.tags = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
