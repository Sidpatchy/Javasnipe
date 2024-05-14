package com.sidpatchy.javasnipe.APIObject.Asset;

import com.sidpatchy.javasnipe.APIObject.Company.Company;
import com.sidpatchy.javasnipe.APIObject.CustomField.CustomFields;
import com.sidpatchy.javasnipe.APIObject.Generic.Date;
import com.sidpatchy.javasnipe.APIObject.Generic.GenericField;
import com.sidpatchy.javasnipe.APIObject.Generic.Location;

/**
 * Builder class for creating instances of Asset.
 */
public class AssetBuilder {

    private final Asset asset;

    public AssetBuilder() {
        this.asset = new Asset();
    }

    public AssetBuilder setId(int id) {
        asset.setId(id);
        return this;
    }

    public AssetBuilder setName(String name) {
        asset.setName(name);
        return this;
    }

    public AssetBuilder setAssetTag(String assetTag) {
        asset.setAssetTag(assetTag);
        return this;
    }

    public AssetBuilder setSerial(String serial) {
        asset.setSerial(serial);
        return this;
    }

    public AssetBuilder setModel(Model model) {
        asset.setModel(model);
        return this;
    }

    public AssetBuilder setByod(boolean byod) {
        asset.setByod(byod);
        return this;
    }

    public AssetBuilder setRequestable(boolean requestable) {
        asset.setRequestable(requestable);
        return this;
    }

    public AssetBuilder setModelNumber(String modelNumber) {
        asset.setModelNumber(modelNumber);
        return this;
    }

    public AssetBuilder setEol(String eol) {
        asset.setEol(eol);
        return this;
    }

    public AssetBuilder setAssetEolDate(Date assetEolDate) {
        asset.setAssetEolDate(assetEolDate);
        return this;
    }

    public AssetBuilder setStatusLabel(StatusLabel statusLabel) {
        asset.setStatusLabel(statusLabel);
        return this;
    }

    public AssetBuilder setCategory(GenericField category) {
        asset.setCategory(category);
        return this;
    }

    public AssetBuilder setManufacturer(GenericField manufacturer) {
        asset.setManufacturer(manufacturer);
        return this;
    }

    public AssetBuilder setSupplier(GenericField supplier) {
        asset.setSupplier(supplier);
        return this;
    }

    public AssetBuilder setNotes(String notes) {
        asset.setNotes(notes);
        return this;
    }

    public AssetBuilder setOrderNumber(String orderNumber) {
        asset.setOrderNumber(orderNumber);
        return this;
    }

    public AssetBuilder setCompany(Company company) {
        asset.setCompany(company);
        return this;
    }

    public AssetBuilder setLocation(Location location) {
        asset.setLocation(location);
        return this;
    }

    public AssetBuilder setRtdLocation(Location rtdLocation) {
        asset.setRtdLocation(rtdLocation);
        return this;
    }

    public AssetBuilder setImage(String image) {
        asset.setImage(image);
        return this;
    }

    public AssetBuilder setQr(String qr) {
        asset.setQr(qr);
        return this;
    }

    public AssetBuilder setAltBarcode(String altBarcode) {
        asset.setAltBarcode(altBarcode);
        return this;
    }

    public AssetBuilder setAssignedTo(GenericField assignedTo) {
        asset.setAssignedTo(assignedTo);
        return this;
    }

    public AssetBuilder setWarrantyMonths(Integer warrantyMonths) {
        asset.setWarrantyMonths(warrantyMonths);
        return this;
    }

    public AssetBuilder setWarrantyExpires(String warrantyExpires) {
        asset.setWarrantyExpires(warrantyExpires);
        return this;
    }

    public AssetBuilder setCreatedAt(Date createdAt) {
        asset.setCreatedAt(createdAt);
        return this;
    }

    public AssetBuilder setUpdatedAt(Date updatedAt) {
        asset.setUpdatedAt(updatedAt);
        return this;
    }

    public AssetBuilder setLastAuditDate(Date lastAuditDate) {
        asset.setLastAuditDate(lastAuditDate);
        return this;
    }

    public AssetBuilder setNextAuditDate(Date nextAuditDate) {
        asset.setNextAuditDate(nextAuditDate);
        return this;
    }

    public AssetBuilder setDeletedAt(String deletedAt) {
        asset.setDeletedAt(deletedAt);
        return this;
    }

    public AssetBuilder setPurchaseDate(Date purchaseDate) {
        asset.setPurchaseDate(purchaseDate);
        return this;
    }

    public AssetBuilder setAge(String age) {
        asset.setAge(age);
        return this;
    }

    public AssetBuilder setLastCheckout(Date lastCheckout) {
        asset.setLastCheckout(lastCheckout);
        return this;
    }

    public AssetBuilder setLastCheckin(Date lastCheckin) {
        asset.setLastCheckin(lastCheckin);
        return this;
    }

    public AssetBuilder setExpectedCheckin(Date expectedCheckin) {
        asset.setExpectedCheckin(expectedCheckin);
        return this;
    }

    public AssetBuilder setPurchaseCost(String purchaseCost) {
        asset.setPurchaseCost(purchaseCost);
        return this;
    }

    public AssetBuilder setCheckinCounter(int checkinCounter) {
        asset.setCheckinCounter(checkinCounter);
        return this;
    }

    public AssetBuilder setCheckoutCounter(int checkoutCounter) {
        asset.setCheckoutCounter(checkoutCounter);
        return this;
    }

    public AssetBuilder setRequestsCounter(int requestsCounter) {
        asset.setRequestsCounter(requestsCounter);
        return this;
    }

    public AssetBuilder setUserCanCheckout(boolean userCanCheckout) {
        asset.setUserCanCheckout(userCanCheckout);
        return this;
    }

    public AssetBuilder setBookValue(String bookValue) {
        asset.setBookValue(bookValue);
        return this;
    }

    public AssetBuilder setCustomFields(CustomFields customFields) {
        asset.setCustomFields(customFields);
        return this;
    }

    public AssetBuilder setAvailableActions(AvailableActions availableActions) {
        asset.setAvailableActions(availableActions);
        return this;
    }

    /**
     * Validates that all required fields are set.
     * @throws IllegalStateException if any required field is not set.
     */
    private void validateAssetForCreation() {
        if (asset.getAssetTag() == null || asset.getAssetTag().trim().isEmpty()) {
            throw new IllegalStateException("Asset tag is required and cannot be empty.");
        }
        if (asset.getModel() == null) {
            throw new IllegalStateException("Model information is required.");
        }
        if (asset.getStatusLabel() == null) {
            throw new IllegalStateException("Status is required.");
        }
    }

    public Asset build() {
        return asset;
    }
}

