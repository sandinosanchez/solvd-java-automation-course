package com.solvd.sandinosanchez.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Photo extends BaseModel {
    private String url;

    public Photo() {}

    public Photo(String url) {
        this.url = url;
    }

    public Photo(Long id, String url) {
        super(id);
        this.url = url;
    }

    public static Photo initializePhoto(ResultSet rs) throws SQLException {
        return new Photo(rs.getLong("id"),
                rs.getString("file_url"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
