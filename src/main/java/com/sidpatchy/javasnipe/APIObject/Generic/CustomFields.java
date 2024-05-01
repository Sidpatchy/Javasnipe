package com.sidpatchy.javasnipe.APIObject.Generic;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class CustomFields {
    @SerializedName("custom_fields")
    private Map<String, CustomField> fields;

    public Map<String, CustomField> getFields() {
        if (fields == null) {
            fields = new HashMap<>();
        }
        return fields;
    }

    public void setFields(Map<String, CustomField> fields) {
        this.fields = fields;
    }

    public CustomField getField(String key) {
        return fields.get(key);
    }
}
