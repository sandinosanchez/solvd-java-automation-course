package com.solvd.sandinosanchez.connectionpool.models;

import java.util.ArrayList;
import java.util.List;

public class Photo extends BaseModel {
    private String url;
    private List<Tag> tags;

    public Photo() {}

    public Photo(long id, String url) {
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

    @Override
    public String toString() {
        return "Photo{" +
                "url='" + url + '\'' +
                '}';
    }
}
