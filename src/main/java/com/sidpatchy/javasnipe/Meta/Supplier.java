package com.sidpatchy.javasnipe.Meta;

/**
 * The Supplier class represents a supplier of goods or services.
 * It contains information about the supplier's ID and name.
 */
public class Supplier {
    private Integer id; // Can be null
    private String name;

    /**
     * Retrieves the ID of the Supplier.
     *
     * @return The ID of the Supplier. It can be null.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the ID of the Supplier.
     *
     * @param id The ID of the Supplier to be set. It can be null.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the supplier.
     *
     * @return The name of the supplier.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the supplier.
     *
     * @param name the new name to set for the supplier
     */
    public void setName(String name) {
        this.name = name;
    }
}
