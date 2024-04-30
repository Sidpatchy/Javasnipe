package com.sidpatchy.javasnipe.Meta;

public class Manufacturer {
    private int id;
    private String name;

    /**
     * Returns the identification number of the Manufacturer.
     *
     * @return the identification number of the Manufacturer
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the Manufacturer.
     *
     * @param id the ID of the Manufacturer to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the manufacturer.
     *
     * @return The name of the manufacturer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Manufacturer.
     *
     * @param name the new name for the Manufacturer
     */
    public void setName(String name) {
        this.name = name;
    }
}
