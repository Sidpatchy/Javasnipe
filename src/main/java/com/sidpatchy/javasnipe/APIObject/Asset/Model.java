package com.sidpatchy.javasnipe.APIObject.Asset;

/**
 * Represents an asset model.
 */
public class Model {
    private int id;
    private String name;

    /**
     * Retrieves the ID of the model.
     *
     * @return The ID of the model.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the model.
     *
     * @param id the ID to set for the model
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the Model object.
     *
     * @return The name of the Model object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Model object.
     *
     * @param name the new name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
}
