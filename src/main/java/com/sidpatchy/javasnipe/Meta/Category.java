package com.sidpatchy.javasnipe.Meta;

/**
 * This class represents a Category which includes an ID and a name.
 */
public class Category {
    private int id;
    private String name;

    /**
     * Gets the ID of the Category.
     *
     * @return the ID of the Category
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the Category.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the Category.
     *
     * @return the name of the Category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name the new name for the category
     */
    public void setName(String name) {
        this.name = name;
    }
}
