package com.solvd.sandinosanchez.connectionpool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseModel {
    @JsonProperty("Id")
    private Long id;

    public BaseModel() {
    }

    public BaseModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
