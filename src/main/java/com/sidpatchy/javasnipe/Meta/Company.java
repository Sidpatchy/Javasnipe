package com.sidpatchy.javasnipe.Meta;

/**
 * The Company class represents a company object with an ID and a name.
 */
public class Company {
    private Integer id; // Can be null
    private String name;

    /**
     * Retrieves the ID of the company.
     *
     * @return The ID of the company as an Integer. This value can be null.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the company.
     *
     * @param id the ID to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the company.
     *
     * @return the name of the company
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the company.
     *
     * @param name the new name for the company
     */
    public void setName(String name) {
        this.name = name;
    }
}
