package com.sidpatchy.javasnipe.Asset;

/**
 * Represents a set of available actions that can be performed.
 */
public class AvailableActions {
    private boolean checkout;
    private boolean checkin;
    private boolean clone;
    private boolean restore;
    private boolean update;
    private boolean delete;

    /**
     * Checks if the checkout action is available.
     *
     * @return true if the checkout action is available, false otherwise.
     */
    public boolean canCheckout() {
        return checkout;
    }

    /**
     * Sets the checkout status of the AvailableActions object.
     *
     * @param checkout the new checkout status
     */
    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    /**
     * Determines if the "checkin" action is available.
     *
     * @return true if the "checkin" action is available, false otherwise
     */
    public boolean canCheckin() {
        return checkin;
    }

    /**
     * Sets the value of the "checkin" attribute.
     *
     * @param checkin the new value for the "checkin" attribute.
     */
    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    /**
     * This method returns the value of the 'clone' attribute of the AvailableActions class.
     *
     * @return the value of the 'clone' attribute.
     */
    public boolean canClone() {
        return clone;
    }

    /**
     * Sets the value of the clone attribute in the AvailableActions class.
     *
     * @param clone The new value for the clone attribute.
     */
    public void canClone(boolean clone) {
        this.clone = clone;
    }

    /**
     * Returns the value of the 'restore' property.
     *
     * @return {@code true} if the 'restore' property is set to true, {@code false} otherwise.
     */
    public boolean canRestore() {
        return restore;
    }

    /**
     * Sets the value of the "restore" field in the "AvailableActions" class.
     *
     * @param restore The new value for the "restore" field.
     */
    public void setRestore(boolean restore) {
        this.restore = restore;
    }

    /**
     * Determines if the update action is available.
     *
     * @return {@code true} if the update action is available, {@code false} otherwise.
     */
    public boolean canUpdate() {
        return update;
    }

    /**
     * Sets the update flag to indicate whether the action should perform an update operation.
     * If the flag is set to true, the action will perform an update operation. Otherwise, it will not.
     *
     * @param update the boolean value indicating whether the update operation should be performed
     */
    public void setUpdate(boolean update) {
        this.update = update;
    }

    /**
     * Checks if the delete action is enabled.
     *
     * @return true if the delete action is enabled, false otherwise.
     */
    public boolean canDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete flag.
     *
     * @param delete the value to be set for the delete flag
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
