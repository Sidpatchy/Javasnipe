package com.sidpatchy.javasnipe.APIObject.Generic;

import java.util.Optional;

/**
 * The GenericField class represents a generic field.
 */
public class GenericField {
    private int id;
    private String name;

    /**
     * Gets the ID of the GenericField.
     *
     * @return the ID of the GenericField
     */
    public Optional<Integer> getId() {
        return Optional.of(id);
    }

    /**
     * Sets the ID of the GenericField.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the GenericField.
     *
     * @return the name of the GenericField
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the GenericField.
     *
     * @param name the new name for the GenericField
     */
    public void setName(String name) {
        this.name = name;
    }
}
