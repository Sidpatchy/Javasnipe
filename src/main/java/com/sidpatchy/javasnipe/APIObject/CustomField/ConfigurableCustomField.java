package com.sidpatchy.javasnipe.APIObject.CustomField;

import com.google.gson.annotations.SerializedName;
import com.sidpatchy.javasnipe.APIObject.Generic.Date;
import com.sidpatchy.javasnipe.APIObject.Generic.GenericField;

import java.util.List;

/**
 * The ConfigurableCustomField class represents a custom field that can be configured with various properties.
 * It extends the GenericField class and adds additional properties specific to configurable custom fields.
 * <p>
 * Not to be confused with {@link CustomField} which is the object attached to assets. This is the parent of custom
 * fields, and is how they can be configured and created.
 */
public class ConfigurableCustomField extends GenericField {
    @SerializedName("db_column_name")
    private String dbColumnName;
    @SerializedName("format")
    private String format;
    @SerializedName("field_values")
    private String fieldValues;
    @SerializedName("field_values_array")
    private List<String> fieldValuesArray;
    @SerializedName("type")
    private String type;
    @SerializedName("required")
    private boolean required;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;

    /**
     * Returns the database column name associated with the ConfigurableCustomField.
     *
     * @return the database column name
     */
    public String getDbColumnName() {
        return dbColumnName;
    }

    /**
     * Sets the database column name for the ConfigurableCustomField object.
     *
     * @param dbColumnName the database column name to be set
     */
    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    /**
     * Retrieves the format from the ConfigurableCustomField object.
     *
     * @return the format string
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format for the ConfigurableCustomField.
     *
     * @param format the format to be set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Returns the field values of the ConfigurableCustomField object.
     *
     * @return the field values of the ConfigurableCustomField as a String
     */
    public String getFieldValues() {
        return fieldValues;
    }

    /**
     * Sets the value of the fieldValues property in the ConfigurableCustomField object.
     *
     * @param fieldValues the new value for the fieldValues property
     */
    public void setFieldValues(String fieldValues) {
        this.fieldValues = fieldValues;
    }

    /**
     * Retrieves the value of the fieldValuesArray property.
     *
     * @return The value of the fieldValuesArray property.
     */
    public List<String> getFieldValuesArray() {
        return fieldValuesArray;
    }

    /**
     * Sets the value of the fieldValuesArray property in the ConfigurableCustomField class.
     *
     * @param fieldValuesArray the new value for the fieldValuesArray property
     */
    public void setFieldValuesArray(List<String> fieldValuesArray) {
        this.fieldValuesArray = fieldValuesArray;
    }

    /**
     * Returns the type of the ConfigurableCustomField. The type indicates the data type or format of the field value.
     *
     * @return The type of the ConfigurableCustomField.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the ConfigurableCustomField.
     *
     * @param type the new type for the ConfigurableCustomField
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns whether the field is required or not.
     *
     * @return true if the field is required, false otherwise
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Sets the required flag for the Configurable Custom Field.
     *
     * @param required the value indicating whether the Configurable Custom Field is required or not
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * Retrieves the creation date of the ConfigurableCustomField object.
     *
     * @return the creation date of the ConfigurableCustomField object
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the created date for the ConfigurableCustomField.
     *
     * @param createdAt the created date for the ConfigurableCustomField
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the updated date for the ConfigurableCustomField object.
     *
     * @return the updated date of the field
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the updatedAt field of the ConfigurableCustomField object.
     *
     * @param updatedAt the new value to set for updatedAt field
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
