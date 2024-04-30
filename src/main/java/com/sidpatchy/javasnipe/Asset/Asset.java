package com.sidpatchy.javasnipe.Asset;

import com.google.gson.annotations.SerializedName;
import com.sidpatchy.javasnipe.Meta.*;

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
    private AssetEolDate assetEolDate;
    @SerializedName("status_label")
    private StatusLabel statusLabel;
    private Category category;
    private Manufacturer manufacturer;
    private Supplier supplier;
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
    private Person assignedTo;
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
    @SerializedName("custom_fields")
    private CustomFields customFields;
    @SerializedName("available_actions")
    private AvailableActions availableActions;

    /**
     * Retrieves the ID of the Asset.
     *
     * @return The ID of the Asset.
     */
    public int getId() {
        return id;
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
     * Retrieves the name of the Asset.
     *
     * @return The name of the Asset.
     */
    public String getName() {
        return name;
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
     * Retrieves the serial number of the asset.
     *
     * @return The serial number of the asset.
     */
    public String getSerial() {
        return serial;
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
     * Retrieves the value of the byod field.
     *
     * @return true if the asset supports Bring Your Own Device (BYOD), false otherwise
     */
    public boolean isByod() {
        return byod;
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
     * Checks whether the asset is requestable or not.
     *
     * @return true if the asset is requestable, false otherwise.
     */
    public boolean isRequestable() {
        return requestable;
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
     * Retrieves the model number of the Asset.
     *
     * @return The model number of the Asset.
     */
    public String getModelNumber() {
        return modelNumber;
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
     * Retrieves the end of life (EOL) information for the asset.
     *
     * @return The end of life (EOL) information as a string.
     */
    public String getEol() {
        return eol;
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
     * Retrieves the End-of-Life (EOL) date of the asset.
     *
     * @return The AssetEolDate object representing the EOL date of the asset.
     */
    public AssetEolDate getAssetEolDate() {
        return assetEolDate;
    }

    /**
     * Sets the EOL (End of Life) date for the asset.
     *
     * @param assetEolDate The AssetEolDate object representing the EOL date to set for the asset.
     */
    public void setAssetEolDate(AssetEolDate assetEolDate) {
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
     * Retrieves the category of the asset.
     *
     * @return The Category object representing the category of the asset.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category for the object.
     *
     * @param category the category to be set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * This method returns the manufacturer of a product.
     *
     * @return The manufacturer of the product.
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the product.
     *
     * @param manufacturer the manufacturer of the product
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Returns the supplier associated with this object.
     *
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the supplier for this object.
     *
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Retrieves the notes associated with the object.
     *
     * @return The notes as a string.
     */
    public String getNotes() {
        return notes;
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
     * @return the order number
     */
    public String getOrderNumber() {
        return orderNumber;
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
     * Retrieves the Company object associated with this method.
     *
     * @return the Company object
     */
    public Company getCompany() {
        return company;
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
     * Retrieves the location.
     *
     * @return the location object.
     */
    public Location getLocation() {
        return location;
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
     * Returns the RTD (Real-Time Data) location.
     *
     * @return the RTD location as a Location object
     */
    public Location getRtdLocation() {
        return rtdLocation;
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
     * Retrieves the image associated with this object.
     *
     * @return The image.
     */
    public String getImage() {
        return image;
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
     * Retrieves the QR code.
     *
     * @return the QR code as a string
     */
    public String getQr() {
        return qr;
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
     * Retrieves the alternative barcode associated with this object.
     *
     * @return The alternative barcode value.
     */
    public String getAltBarcode() {
        return altBarcode;
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
     * Returns the person assigned to this object.
     *
     * @return the person object representing the assigned person
     */
    public Person getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the assigned person for this task.
     *
     * @param assignedTo the person to be assigned to this task
     */
    public void setAssignedTo(Person assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Retrieves the number of warranty months for this product.
     *
     * @return The number of warranty months as an Integer.
     */
    public Integer getWarrantyMonths() {
        return warrantyMonths;
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
     * Returns the warranty expiration date.
     *
     * @return the warranty expiration date as a string
     */
    public String getWarrantyExpires() {
        return warrantyExpires;
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
     * Returns the timestamp representing the creation time of the object.
     *
     * @return The timestamp representing the creation time of the object.
     */
    public Date getCreatedAt() {
        return createdAt;
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
     * Returns the timestamp of when the object was last updated.
     *
     * @return The timestamp of when the object was last updated.
     */
    public Date getUpdatedAt() {
        return updatedAt;
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
     * Returns the last audit date.
     *
     * @return the last audit date
     */
    public Date getLastAuditDate() {
        return lastAuditDate;
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
     * @return the next audit date as a Date object
     */
    public Date getNextAuditDate() {
        return nextAuditDate;
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
    public String getDeletedAt() {
        return deletedAt;
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
    public Date getPurchaseDate() {
        return purchaseDate;
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
     * Retrieves the age of an object.
     *
     * @return The age of the object as a String.
     */
    public String getAge() {
        return age;
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
     * @return The date of the last checkout as a Date object.
     */
    public Date getLastCheckout() {
        return lastCheckout;
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
     * Retrieves the date and time of the last check-in.
     *
     * @return the date and time of the last check-in as a Date object.
     */
    public Date getLastCheckin() {
        return lastCheckin;
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
     * Retrieves the expected check-in date.
     *
     * @return The expected check-in date as a Date object.
     */
    public Date getExpectedCheckin() {
        return expectedCheckin;
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
     * Retrieves the purchase cost of an item.
     *
     * @return The purchase cost of the item as a String.
     */
    public String getPurchaseCost() {
        return purchaseCost;
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
     * Returns the value of the check-in counter.
     *
     * @return The value of the check-in counter.
     */
    public int getCheckinCounter() {
        return checkinCounter;
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
     * Returns the current value of the checkout counter.
     *
     * @return The checkout counter value.
     */
    public int getCheckoutCounter() {
        return checkoutCounter;
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
     * Retrieves the value of the requestsCounter field.
     *
     * @return The value of the requestsCounter field.
     */
    public int getRequestsCounter() {
        return requestsCounter;
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
     * Checks if the user can perform checkout.
     *
     * @return true if the user can perform checkout, false otherwise.
     */
    public boolean canUserCheckout() {
        return userCanCheckout;
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
     * Gets the book value.
     *
     * @return The book value as a String.
     */
    public String getBookValue() {
        return bookValue;
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
     * Retrieves the custom fields associated with the asset.
     *
     * @return the CustomFields object representing the custom fields of the asset
     */
    public CustomFields getCustomFields() {
        return customFields;
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
     * This method is used to retrieve the available actions for an asset.
     *
     * @return The AvailableActions object representing the available actions.
     */
    public AvailableActions getAvailableActions() {
        return availableActions;
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
