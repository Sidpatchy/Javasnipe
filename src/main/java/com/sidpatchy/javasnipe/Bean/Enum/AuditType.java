package com.sidpatchy.javasnipe.Bean.Enum;

public enum AuditType {
    DUE("due"),
    OVERDUE("overdue");

    private final String type;

    AuditType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
