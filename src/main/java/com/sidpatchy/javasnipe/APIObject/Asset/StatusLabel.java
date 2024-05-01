package com.sidpatchy.javasnipe.APIObject.Asset;

import com.google.gson.annotations.SerializedName;

public class StatusLabel {
    private int id;
    private String name;
    @SerializedName("status_type")
    private String statusType;
    @SerializedName("status_meta")
    private String statusMeta;

    /**
     * Gets the ID of the StatusLabel object.
     *
     * @return The ID of the StatusLabel object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the StatusLabel.
     *
     * @param id the ID of the StatusLabel
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the StatusLabel.
     *
     * @return the name of the StatusLabel.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the status label.
     *
     * @param name the new name for the status label
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the status type of the StatusLabel object.
     *
     * @return The status type as a String.
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * Sets the status type of the StatusLabel.
     *
     * @param statusType the new status type to be set
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * Retrieves the status meta information.
     *
     * @return The status meta as a string.
     */
    public String getStatusMeta() {
        return statusMeta;
    }

    /**
     * Sets the status meta of the StatusLabel object.
     *
     * @param statusMeta the new status meta to be set
     */
    public void setStatusMeta(String statusMeta) {
        this.statusMeta = statusMeta;
    }
}
