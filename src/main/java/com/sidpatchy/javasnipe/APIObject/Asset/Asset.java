package com.sidpatchy.javasnipe.APIObject.Asset;

import com.google.gson.annotations.SerializedName;
import com.sidpatchy.javasnipe.APIObject.Company.Company;
import com.sidpatchy.javasnipe.APIObject.Generic.CustomFields;
import com.sidpatchy.javasnipe.APIObject.Generic.Date;
import com.sidpatchy.javasnipe.APIObject.Generic.GenericField;
import com.sidpatchy.javasnipe.APIObject.Generic.Location;

import java.util.Optional;

/**
 * Represents an asset.
 */
public class Asset {
    private int id;
    private String name;
    @SerializedName("asset_tag")
    private String assetTag;
    private String serial;
    private Model model;
    private boolean byod;
    private boolean requestable;
    @SerializedName("model_number")
    private String modelNumber;
    @SerializedName("eol")
    private String eol;
    private Date assetEolDate;
    @SerializedName("status_label")
    private StatusLabel statusLabel;
    private GenericField category;
    private GenericField manufacturer;
    private GenericField supplier;
    private String notes;
    @SerializedName("order_number")
    private String orderNumber;
    private Company company;
    private Location location;
    @SerializedName("rtd_location")
    private Location rtdLocation;
    private String image;
    private String qr;
    @SerializedName("alt_barcode")
    private String altBarcode;
    @SerializedName("assigned_to")
    private GenericField assignedTo;
    @SerializedName("warranty_months")
    private Integer warrantyMonths;
    @SerializedName("warranty_expires")
    private String warrantyExpires;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    private Date lastAuditDate;
    private Date nextAuditDate;
    @SerializedName("deleted_at")
    private String deletedAt;
    private Date purchaseDate;
    private String age;
    private Date lastCheckout;
    private Date lastCheckin;
    private Date expectedCheckin;
    @SerializedName("purchase_cost")
    private String purchaseCost;
    @SerializedName("checkin_counter")
    private int checkinCounter;
    @SerializedName("checkout_counter")
    private int checkoutCounter;
    @SerializedName("requests_counter")
    private int requestsCounter;
    @SerializedName("user_can_checkout")
    private boolean userCanCheckout;
    @SerializedName("book_value")
    private String bookValue;
    @SerializedName("custom_fields") // todo known to be broken
    private CustomFields customFields;
    @SerializedName("available_actions")
    private AvailableActions availableActions;

    /**
     * Retrieves the ID of this object.
     *
     * @return an {@link Optional} containing the ID as an Integer if present, or an {@link Optional#empty()} if not available.
     */
    public Optional<Integer> getId() {
        return Optional.of(id);
    }

    /**
     * Sets the ID of the Asset.
     *
     * @param id The ID to set for the Asset.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the object.
     *
     * @return an {@link Optional} containing the name of the object, or an {@link Optional#empty()} if the name is not set
     */
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    /**
     * Sets the name of the asset.
     *
     * @param name The name to set for the asset.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the asset tag of the Asset.
     *
     * @return The asset tag of the Asset.
     */
    public String getAssetTag() {
        return assetTag;
    }

    /**
     * Sets the asset tag for the Asset.
     *
     * @param assetTag The asset tag to set for the Asset.
     */
    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    /**
     * Retrieves the serial number.
     *
     * @return an {@link Optional} object containing the serial number,
     *         or an {@link Optional#empty()} if the serial number is null
     */
    public Optional<String> getSerial() {
        return Optional.ofNullable(serial);
    }

    /**
     * Sets the serial number for the Asset.
     *
     * @param serial The serial number to set for the Asset.
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Retrieves the Model associated with the Asset.
     *
     * @return The Model object representing the model of the Asset.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the model for the Asset.
     *
     * @param model The Model object representing the model to set for the Asset.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Checks if the device supports BYOD (Bring Your Own Device).
     *
     * @return an {@link Optional<Boolean>} value indicating if the device supports BYOD. The {@link Optional} may contain a boolean value if it is available,
     *         or it may be empty if the BYOD status cannot be determined.
     */
    public Optional<Boolean> isByod() {
        return Optional.of(byod);
    }

    /**
     * Sets the BYOD (Bring Your Own Device) flag for the Asset.
     *
     * @param byod The BYOD flag to set for the Asset. True if the Asset is a BYOD device, false otherwise.
     */
    public void setByod(boolean byod) {
        this.byod = byod;
    }

    /**
     * Determines whether the request is requestable.
     *
     * @return an {@link Optional<Boolean>} containing the value indicating whether the request is requestable.
     * If the value is present, it is set to {@code true}, otherwise {@code false}.
     */
    public Optional<Boolean> isRequestable() {
        return Optional.of(requestable);
    }

    /**
     * Sets the requestable flag for the asset.
     *
     * @param requestable The new value for the requestable flag. True if the asset is requestable, false otherwise.
     */
    public void setRequestable(boolean requestable) {
        this.requestable = requestable;
    }

    /**
     * Retrieves the model number of the object.
     *
     * @return an {@link Optional} object containing the model number if it is present, otherwise an {@link Optional#empty()}.
     */
    public Optional<String> getModelNumber() {
        return Optional.ofNullable(modelNumber);
    }

    /**
     * Sets the model number for the Asset.
     *
     * @param modelNumber The model number to set for the Asset.
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * Retrieves the end-of-line character(s) used in the current context.
     *
     * @return an {@link Optional} containing the end-of-line character(s) as a String,
     *         or an {@link Optional#empty()} if no end-of-line character(s) are defined.
     */
    public Optional<String> getEol() {
        return Optional.ofNullable(eol);
    }

    /**
     * Sets the End of Life (EOL) for the Asset.
     *
     * @param eol The EOL value to set for the Asset.
     */
    public void setEol(String eol) {
        this.eol = eol;
    }

    /**
     * Retrieves the end-of-life date of the asset.
     *
     * @return An {@link Optional} object containing the end-of-life date of the asset, or an {@link Optional#empty()} if the end-of-life date is not set.
     */
    public Optional<Date> getAssetEolDate() {
        return Optional.ofNullable(assetEolDate);
    }

    /**
     * Sets the EOL (End of Life) date for the asset.
     *
     * @param assetEolDate The Date object representing the EOL date to set for the asset.
     */
    public void setAssetEolDate(Date assetEolDate) {
        this.assetEolDate = assetEolDate;
    }

    /**
     * Retrieves the StatusLabel associated with the Asset.
     *
     * @return The StatusLabel object representing the status label of the Asset.
     */
    public StatusLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * Sets the status label for the Asset.
     *
     * @param statusLabel The StatusLabel object representing the status label to set for the Asset.
     */
    public void setStatusLabel(StatusLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    /**
     * Returns the category of the GenericField.
     *
     * @return {@link Optional} containing the category of the GenericField,
     *         or an {@link Optional#empty()} if the category is null.
     */
    public Optional<GenericField> getCategory() {
        return Optional.ofNullable(category);
    }

    /**
     * Sets the category for the object.
     *
     * @param category the category to be set
     */
    public void setCategory(GenericField category) {
        this.category = category;
    }

    /**
     * Returns the manufacturer of the object.
     *
     * @return an {@link Optional} containing the manufacturer, or an {@link Optional#empty()} if the manufacturer is null
     */
    public Optional<GenericField> getManufacturer() {
        return Optional.ofNullable(manufacturer);
    }

    /**
     * Sets the manufacturer of the product.
     *
     * @param manufacturer the manufacturer of the product
     */
    public void setManufacturer(GenericField manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Returns the supplier of the field.
     *
     * @return an {@link Optional} containing the supplier of the field, or an {@link Optional#empty()} if the supplier is null.
     */
    public Optional<GenericField> getSupplier() {
        return Optional.ofNullable(supplier);
    }

    /**
     * Sets the supplier for this object.
     *
     * @param supplier the supplier to set
     */
    public void setSupplier(GenericField supplier) {
        this.supplier = supplier;
    }

    /**
     * Retrieves the notes associated with an object.
     *
     * @return an {@link Optional} containing the notes if present, otherwise an {@link Optional#empty()}.
     */
    public Optional<String> getNotes() {
        return Optional.ofNullable(notes);
    }

    /**
     * Sets the notes for the object.
     *
     * @param notes the notes to be set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns the order number associated with this object.
     *
     * @return An {@link  Optional} object containing the order number, or an {@link Optional#empty()} if no order number has been set.
     */
    public Optional<String> getOrderNumber() {
        return Optional.ofNullable(orderNumber);
    }

    /**
     * Sets the order number for the current order.
     *
     * @param orderNumber the order number to be set
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Retrieves the company associated with this object.
     *
     * @return an {@link Optional} containing the company, if available.
     *         If no company is associated, an {@link Optional#empty()} is returned.
     */
    public Optional<Company> getCompany() {
        return Optional.ofNullable(company);
    }

    /**
     * Sets the company for this object.
     *
     * @param company the company to be set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Retrieves the location, if available.
     *
     * @return an {@link Optional} containing the location, or {@link Optional#empty()} if no location is available.
     */
    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    /**
     * Sets the location of the object.
     *
     * @param location the new location of the object
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Retrieves the real-time data (RTD) location.
     *
     * @return an {@link Optional} object that contains the RTD location, or {@link Optional#empty()} if the RTD location is null
     */
    public Optional<Location> getRtdLocation() {
        return Optional.ofNullable(rtdLocation);
    }

    /**
     * Sets the real-time data location for the object.
     *
     * @param rtdLocation the real-time data location to be set
     */
    public void setRtdLocation(Location rtdLocation) {
        this.rtdLocation = rtdLocation;
    }

    /**
     * Retrieves the image associated with this object, if any.
     *
     * @return an {@link Optional} object containing the image string, if it exists; otherwise an {@link Optional#empty()}
     */
    public Optional<String> getImage() {
        return Optional.ofNullable(image);
    }

    /**
     * Sets the image of the object.
     *
     * @param image - the path or URL of the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Retrieve the QR code associated with this object.
     *
     * @return An {@link Optional} that may contain the QR code as a String if available, or an {@link Optional#empty()} if the QR code is null.
     */
    public Optional<String> getQr() {
        return Optional.ofNullable(qr);
    }

    /**
     * Sets the QR value.
     *
     * @param qr the QR value to be set
     */
    public void setQr(String qr) {
        this.qr = qr;
    }

    /**
     * Retrieves the alternative barcode associated with the object, if available.
     *
     * @return an {@link Optional} containing the alternative barcode, or an {@link Optional#empty()} if not available
     */
    public Optional<String> getAltBarcode() {
        return Optional.ofNullable(altBarcode);
    }

    /**
     * Sets the alternate barcode for the product.
     *
     * @param altBarcode the alternate barcode to be set
     */
    public void setAltBarcode(String altBarcode) {
        this.altBarcode = altBarcode;
    }

    /**
     * Retrieves the assignedTo field.
     *
     * @return an {@link Optional} object containing the assignedTo field, or an {@link Optional#empty()} if assignedTo is null
     */
    public Optional<GenericField> getAssignedTo() {
        return Optional.ofNullable(assignedTo);
    }

    /**
     * Sets the assigned person for this task.
     *
     * @param assignedTo the person to be assigned to this task
     */
    public void setAssignedTo(GenericField assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Retrieves the warranty months for a product.
     *
     * @return An {@link Optional} value containing the number of warranty months. If the warranty months are not available,
     *         an {@link Optional#empty()} is returned.
     */
    public Optional<Integer> getWarrantyMonths() {
        return Optional.of(warrantyMonths);
    }

    /**
     * Set the warranty duration in months.
     *
     * @param warrantyMonths the warranty duration in months
     */
    public void setWarrantyMonths(Integer warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    /**
     * Retrieves the warranty expiration date, if available.
     *
     * @return an {@link Optional} containing the warranty expiration date, or an {@link Optional#empty()} if no expiration date is set
     */
    public Optional<String> getWarrantyExpires() {
        return Optional.ofNullable(warrantyExpires);
    }

    /**
     * Sets the warranty expiration date for the product.
     *
     * @param warrantyExpires the warranty expiration date to be set
     */
    public void setWarrantyExpires(String warrantyExpires) {
        this.warrantyExpires = warrantyExpires;
    }

    /**
     * Returns the creation date of the object, if available.
     *
     * @return an {@link Optional} object containing the creation date,
     *         or an {@link Optional#empty()} if the creation date is not set.
     */
    public Optional<Date> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    /**
     * Sets the value of createdAt field.
     *
     * @param createdAt the timestamp representing the creation time
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the optional date value representing the last updated timestamp.
     *
     * @return the {@link Optional} Date value of the last updated timestamp, or an {@link Optional#empty()} if no timestamp is set
     */
    public Optional<Date> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    /**
     * Sets the updated at timestamp.
     *
     * @param updatedAt the updated at timestamp to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Retrieves the last audit date.
     *
     * @return {@link Optional} object representing the last audit date,
     *         or an {@link Optional#empty()} if the last audit date is null.
     */
    public Optional<Date> getLastAuditDate() {
        return Optional.ofNullable(lastAuditDate);
    }

    /**
     * Sets the last audit date.
     *
     * @param lastAuditDate the new last audit date
     */
    public void setLastAuditDate(Date lastAuditDate) {
        this.lastAuditDate = lastAuditDate;
    }

    /**
     * Retrieves the next audit date.
     *
     * @return an {@link Optional} object containing the next audit date, if it exists; otherwise an {@link Optional#empty()}.
     */
    public Optional<Date> getNextAuditDate() {
        return Optional.ofNullable(nextAuditDate);
    }

    /**
     * Sets the next audit date for the object.
     *
     * @param nextAuditDate the date of the next audit
     */
    public void setNextAuditDate(Date nextAuditDate) {
        this.nextAuditDate = nextAuditDate;
    }

    /**
     * Retrieves the deletedAt value of the object.
     *
     * @return The deletedAt value.
     */
    public Optional<String> getDeletedAt() {
        return Optional.ofNullable(deletedAt);
    }

    /**
     * Sets the value of the "deletedAt" field.
     *
     * @param deletedAt The new value for the "deletedAt" field.
     */
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * Returns the purchase date of the product.
     *
     * @return the purchase date of the product.
     */
    public Optional<Date> getPurchaseDate() {
        return Optional.ofNullable(purchaseDate);
    }

    /**
     * Sets the purchase date of the object.
     *
     * @param purchaseDate the purchase date to be set
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Returns the age of a person as an optional string.
     *
     * @return an {@link Optional} object containing the age of the person, or an {@link Optional#empty()} if the age is null.
     */
    public Optional<String> getAge() {
        return Optional.ofNullable(age);
    }

    /**
     * Sets the age of the object.
     *
     * @param age the age of the object
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Retrieves the date of the last checkout.
     *
     * @return an {@link Optional} object containing the date of the last checkout, or an {@link Optional#empty()} if no checkout has occurred
     */
    public Optional<Date> getLastCheckout() {
        return Optional.ofNullable(lastCheckout);
    }

    /**
     * Sets the last checkout date for the item.
     *
     * @param lastCheckout the last checkout date of the item
     */
    public void setLastCheckout(Date lastCheckout) {
        this.lastCheckout = lastCheckout;
    }

    /**
     * Retrieves the last check-in date.
     *
     * @return an {@link Optional} containing the last check-in date, or empty if there is no previous check-in.
     */
    public Optional<Date> getLastCheckin() {
        return Optional.ofNullable(lastCheckin);
    }

    /**
     * Sets the last check-in date.
     *
     * @param lastCheckin the new last check-in date
     */
    public void setLastCheckin(Date lastCheckin) {
        this.lastCheckin = lastCheckin;
    }

    /**
     * Returns the expected check-in date.
     *
     * @return an {@link Optional} date representing the expected check-in date, or empty if it is not set.
     */
    public Optional<Date> getExpectedCheckin() {
        return Optional.ofNullable(expectedCheckin);
    }

    /**
     * Sets the expected check-in date for an item.
     *
     * @param expectedCheckin the expected check-in date for the item
     */
    public void setExpectedCheckin(Date expectedCheckin) {
        this.expectedCheckin = expectedCheckin;
    }

    /**
     * Retrieves the purchase cost as an optional value.
     *
     * @return an {@link Optional} object containing the purchase cost, or an {@link Optional#empty()} if the purchase cost is null.
     */
    public Optional<String> getPurchaseCost() {
        return Optional.ofNullable(purchaseCost);
    }

    /**
     * Sets the purchase cost of an item.
     *
     * @param purchaseCost the new purchase cost of the item. This value should be a String.
     *                    If the item has no purchase cost, pass null.
     */
    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    /**
     * Retrieves the check-in counter.
     *
     * @return an {@link Optional} containing the check-in counter if it exists, otherwise an {@link Optional#empty()}
     */
    public Optional<Integer> getCheckinCounter() {
        return Optional.of(checkinCounter);
    }

    /**
     * Sets the check-in counter value.
     *
     * @param checkinCounter the number of check-in counter to be set
     */
    public void setCheckinCounter(int checkinCounter) {
        this.checkinCounter = checkinCounter;
    }

    /**
     * Retrieves the current value of the checkout counter.
     *
     * @return an {@link Optional} representing the checkout counter value.
     *         If the value is present, it will be wrapped in an {@link Integer}.
     *         If the value is absent, {@link Optional#empty()} will be returned.
     */
    public Optional<Integer> getCheckoutCounter() {
        return Optional.of(checkoutCounter);
    }

    /**
     * Sets the number of checkout counters.
     *
     * @param checkoutCounter the number of checkout counters to set
     */
    public void setCheckoutCounter(int checkoutCounter) {
        this.checkoutCounter = checkoutCounter;
    }

    /**
     * Retrieves the value of the requests counter.
     *
     * @return an {@link Optional} containing the requests counter value
     */
    public Optional<Integer> getRequestsCounter() {
        return Optional.of(requestsCounter);
    }

    /**
     * Sets the requests counter for the asset.
     *
     * @param requestsCounter the new value for the requests counter
     */
    public void setRequestsCounter(int requestsCounter) {
        this.requestsCounter = requestsCounter;
    }

    /**
     * Checks if the user can perform a checkout.
     *
     * @return {@link Optional} object that contains a boolean value indicating if the user can checkout,
     *         or an {@link Optional#empty()} if the value is not available.
     */
    public Optional<Boolean> canUserCheckout() {
        return Optional.of(userCanCheckout);
    }

    /**
     * Sets whether the user can checkout.
     *
     * @param userCanCheckout true if the user can checkout, false otherwise
     */
    public void setUserCanCheckout(boolean userCanCheckout) {
        this.userCanCheckout = userCanCheckout;
    }

    /**
     * Retrieves the value of the book.
     *
     * @return Returns an {@link Optional} object that may contain the value of the book.
     *         If the book value is null, the {@link Optional} object will be empty.
     */
    public Optional<String> getBookValue() {
        return Optional.ofNullable(bookValue);
    }

    /**
     * Sets the book value of a given object to the specified value.
     *
     * @param bookValue the new book value to be set
     */
    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    /**
     * Retrieve the custom fields for an object.
     *
     * @return an {@link Optional} containing the custom fields of the object, or an {@link Optional#empty()} if no custom fields are available.
     */
    public Optional<CustomFields> getCustomFields() {
        return Optional.ofNullable(customFields);
    }

    /**
     * Sets the custom fields for the asset.
     *
     * @param customFields The custom fields to be set for the asset.
     */
    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }

    /**
     * Retrieves the available actions.
     *
     * @return An {@link Optional} containing the available actions, or an {@link Optional#empty()} if there are no actions available.
     */
    public Optional<AvailableActions> getAvailableActions() {
        return Optional.ofNullable(availableActions);
    }

    /**
     * Set the available actions for the Asset.
     *
     * @param availableActions The AvailableActions object containing the available actions.
     */
    public void setAvailableActions(AvailableActions availableActions) {
        this.availableActions = availableActions;
    }
}
