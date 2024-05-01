package com.sidpatchy.javasnipe.APIObject.Person;

public class Person {
    private Integer id; // Can be null
    private String name;

    /**
     * Retrieves the ID of the person.
     *
     * @return the ID of the person, or null if not set
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id the unique identifier for the person (can be null)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name for the person
     */
    public void setName(String name) {
        this.name = name;
    }
}
