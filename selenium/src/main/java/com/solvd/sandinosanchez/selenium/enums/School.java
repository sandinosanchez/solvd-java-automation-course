package com.solvd.sandinosanchez.selenium.enums;

public enum School {
    HOGWARTS("Hogwarts School of Witchcraft and Wizardry"),
    BEAUXBATONS("Beauxbatons Academy of Magic");

    private String name;

    private School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
