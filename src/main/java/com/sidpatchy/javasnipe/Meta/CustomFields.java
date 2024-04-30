package com.sidpatchy.javasnipe.Meta;

import java.util.Map;

/**
 * The CustomFields class represents a collection of custom fields.
 * Each field is identified by a unique key and contains a CustomField object that represents the field information.
 *
 * todo create a FieldFormat & Element class
 */
public class CustomFields {
    private Map<String, CustomField> fields;

    /**
     * Retrieves the CustomField object associated with the given key.
     *
     * @param key the key used to retrieve the CustomField
     * @return the CustomField object associated with the key, or null if not found
     */
    public CustomField getField(String key) {
        return fields.get(key);
    }

    /**
     * Sets a custom field with the specified key and value.
     * If a custom field with the same key already exists, it will be replaced with the new value.
     *
     * @param key   the key of the custom field
     * @param value the value to be set for the custom field
     */
    public void setField(String key, CustomField value) {
        fields.put(key, value);
    }

    /**
     * Returns a map of all the fields in the CustomFields object.
     *
     * @return a map of all the fields in the CustomFields object
     */
    public Map<String, CustomField> getFields() {
        return fields;
    }

    /**
     * Sets the fields of the CustomFields object with the given map of fields.
     *
     * @param fields a Map of fields, where the key is a String representing the field name
     *               and the value is a CustomField object representing the field information.
     *               The map should contain all the fields that need to be set.
     */
    public void setFields(Map<String, CustomField> fields) {
        this.fields = fields;
    }
}

