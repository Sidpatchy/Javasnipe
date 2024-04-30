package com.sidpatchy.javasnipe.Asset;

/**
 * The AssetEolDate class represents a date with a formatted string value. It provides methods to get and set the date and formatted string values.
 */
public class AssetEolDate {
    private String date;
    private String formatted;

    /**
     * Returns the date.
     *
     * @return The date.
     */
    // Getters and setters for date and formatted
    public String getDate() {
        return date;
    }

    /**
     * Sets the date for the AssetEolDate object.
     *
     * @param date the date to be set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the formatted string.
     *
     * @return The formatted string.
     */
    public String getFormatted() {
        return formatted;
    }

    /**
     * Sets the formatted value of the AssetEolDate object.
     * The formatted value is a string representation of the date in a specific format.
     *
     * @param formatted the new formatted value for the AssetEolDate object
     */
    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
