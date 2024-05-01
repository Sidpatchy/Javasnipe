package com.sidpatchy.javasnipe.APIObject.Generic;

/**
 * The Location class represents a location with an ID and a name.
 */
public class Location {
    private int id;
    private String name;

    /**
     * Returns the ID of the Location.
     *
     * @return the ID of the Location
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID for the Location.
     *
     * @param id the ID to set for the Location
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method returns the name of the Location.
     *
     * @return the name of the Location as a string
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Location.
     *
     * @param name the new name for the Location
     */
    public void setName(String name) {
        this.name = name;
    }
}
