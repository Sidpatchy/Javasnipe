package com.sidpatchy.javasnipe.APIObject.Generic;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomFields {
    private Map<String, CustomField> fields;

    public Map<String, CustomField> getFields() {
        if (fields == null) {
            fields = new HashMap<>();
        }
        return fields;
    }

    public void setFields(Map<String, CustomField> fields) {
        if (fields == null) {
            fields = new HashMap<>();
        }
        this.fields = fields;
    }

    public Optional<CustomField> getField(String key) {
        return Optional.ofNullable(fields.get(key));
    }

    public void put(String key ,CustomField field) {
        if (fields == null) {
            fields = new HashMap<>();
        }
        fields.put(key, field);
    }
}
