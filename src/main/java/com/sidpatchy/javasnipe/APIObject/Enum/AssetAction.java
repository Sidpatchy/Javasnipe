package com.sidpatchy.javasnipe.APIObject.Enum;

public enum AssetAction {
    CHECKOUT("checkout"),
    CHECKIN("checkin"),
    RESTORE("restore");

    private final String action;

    AssetAction(String action) {
        this.action = action;
    }

    public String toString() {
        return action;
    }
}
