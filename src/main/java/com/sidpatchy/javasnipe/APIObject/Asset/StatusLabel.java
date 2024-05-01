package com.sidpatchy.javasnipe.APIObject.Asset;

import com.google.gson.annotations.SerializedName;
import com.sidpatchy.javasnipe.APIObject.Generic.GenericField;

public class StatusLabel extends GenericField {
    @SerializedName("status_type")
    private String statusType;
    @SerializedName("status_meta")
    private String statusMeta;

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
