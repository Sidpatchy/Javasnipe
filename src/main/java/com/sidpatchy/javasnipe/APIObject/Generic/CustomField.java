package com.sidpatchy.javasnipe.APIObject.Generic;

/**
 * The CustomField class represents a custom field with a value, field format, and element.
 *
 * todo create a FieldFormat & Element class
 */
public class CustomField {
    private String value;
    private String fieldFormat;
    private String element;

    /**
     * Returns the value of the custom field.
     *
     * @return the value of the custom field
     */
    // Getters and Setters
    public String getValue() {
        return value;
    }

    /**
     * Sets the value for the CustomField.
     *
     * @param value the new value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the field format for this CustomField.
     *
     * @return the field format as a string
     */
    public String getFieldFormat() {
        return fieldFormat;
    }

    /**
     * Sets the field format for the CustomField.
     * This method allows you to specify the format of the field value.
     *
     * @param fieldFormat the field format to be set
     */
    public void setFieldFormat(String fieldFormat) {
        this.fieldFormat = fieldFormat;
    }

    /**
     * Returns the value of the element.
     *
     * @return the value of the element
     */
    public String getElement() {
        return element;
    }

    /**
     * Sets the element of the custom field.
     *
     * @param element the new element value
     */
    public void setElement(String element) {
        this.element = element;
    }
}
