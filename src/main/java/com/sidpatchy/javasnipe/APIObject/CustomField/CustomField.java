package com.sidpatchy.javasnipe.APIObject.CustomField;

import com.google.gson.annotations.SerializedName;

public class CustomField {
    @SerializedName("value")
    private String value;
    @SerializedName("field")
    private String fieldId;
    @SerializedName("field_format")
    private String fieldFormat;
    @SerializedName("element")
    private String element;

    // Getters and setters for each field
    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFieldFormat() {
        return fieldFormat;
    }

    public void setFieldFormat(String fieldFormat) {
        this.fieldFormat = fieldFormat;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
