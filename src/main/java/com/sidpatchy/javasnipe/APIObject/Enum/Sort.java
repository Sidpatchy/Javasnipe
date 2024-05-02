package com.sidpatchy.javasnipe.APIObject.Enum;

public enum Sort {
    ID("id"),
    NAME("name"),
    ASSET_TAG("asset_tag"),
    SERIAL("serial"),
    MODEL("model"),
    MODEL_NUMBER("model_number"),
    LAST_CHECKOUT("last_checkout"),
    CATEGORY("category"),
    MANUFACTURER("manufacturer"),
    NOTES("notes"),
    EXPECTED_CHECKIN("expected_checkin"),
    ORDER_NUMBER("order_number"),
    COMPANY_NAME("companyname"),
    LOCATION("location"),
    IMAGE("image"),
    STATUS_LABEL("status_label"),
    ASSIGNED_TO("assigned_to"),
    CREATED_AT("created_at"),
    PURCHASE_DATE("purchase_date"),
    PURCHASE_COST("purchase_cost");

    private final String field;

    Sort(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}
