package com.solvd.sandinosanchez.model;

public class Gender extends BaseModel {
    private String name;

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
