package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gender extends BaseModel {
    @JsonProperty("Name")
    private String name;

    public Gender(){}

    public Gender(String name) {
        this.name = name;
    }

    public Gender(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return '{'+ name + '}';
    }
}
