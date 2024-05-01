package com.sidpatchy.javasnipe.APIObject.Generic;

/**
 * The Date class represents a date object.
 * It has methods to get and set the date value and to get and set the formatted version of the date.
 *
 * todo this should probably be written such that the user inserts something like a Unix timestamp or similar to avoid
 * todo angering the Snipe-IT API gods
 */
public class Date {
    private String date;
    private String formatted;

    /**
     * Gets the date value.
     *
     * @return the date value
     */
    // Getters and setters
    public String getDate() {
        return date;
    }

    /**
     * Sets the date for the Date object.
     *
     * @param date the date to be set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the formatted date string.
     *
     * @return The formatted date string.
     */
    public String getFormatted() {
        return formatted;
    }

    /**
     * Sets the formatted version of the date.
     *
     * @param formatted the formatted version of the date
     * @return void
     */
    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
