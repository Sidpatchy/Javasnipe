package com.sidpatchy.javasnipe.APIObject.Enum;

public enum Order {
    ASCENDING("asc"),
    DESCENDING("desc");

    private final String direction;

    Order(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
