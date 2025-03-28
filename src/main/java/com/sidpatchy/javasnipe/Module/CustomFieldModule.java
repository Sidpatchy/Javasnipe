package com.sidpatchy.javasnipe.Module;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sidpatchy.javasnipe.Bean.CustomField.ConfigurableCustomField;
import com.sidpatchy.javasnipe.IO.HttpConnectionManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CustomFieldModule {

    private final HttpConnectionManager connectionManager;
    private static final String CUSTOM_FIELDS_ENDPOINT = "/fields";

    public CustomFieldModule(HttpConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Fetches all custom fields with pagination.
     *
     * @param limit  The number of custom fields per page.
     * @param offset The offset to start fetching custom fields.
     * @return A CompletableFuture that resolves to a list of custom fields.
     */
    public CompletableFuture<List<ConfigurableCustomField>> fetchCustomFields(int limit, int offset) {
        TypeToken<List<ConfigurableCustomField>> type = new TypeToken<>() {};
        return connectionManager.fetchAllPages(CUSTOM_FIELDS_ENDPOINT, type.getType(), limit, offset);
    }

    /**
     * Fetches a custom field by its ID.
     *
     * @param fieldId The ID of the custom field.
     * @return A CompletableFuture that resolves to the custom field.
     */
    public CompletableFuture<ConfigurableCustomField> fetchCustomFieldById(int fieldId) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + fieldId;
        return connectionManager.get(endpoint, ConfigurableCustomField.class);
    }

    /**
     * Creates a new custom field.
     *
     * @param customField The custom field to create.
     * @return A CompletableFuture that resolves to the created custom field.
     */
    public CompletableFuture<ConfigurableCustomField> createCustomField(ConfigurableCustomField customField) {
        return connectionManager.post(CUSTOM_FIELDS_ENDPOINT, customField, ConfigurableCustomField.class);
    }

    /**
     * Updates an existing custom field.
     *
     * @param customField The custom field with updated information.
     * @return A CompletableFuture that resolves to the updated custom field.
     */
    public CompletableFuture<ConfigurableCustomField> updateCustomField(@NotNull ConfigurableCustomField customField) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + customField.getId().orElseThrow(() -> new IllegalArgumentException("Custom field must have an ID"));
        return connectionManager.put(endpoint, customField, ConfigurableCustomField.class);
    }

    /**
     * Partially updates a custom field.
     *
     * @param fieldId      The ID of the custom field to update.
     * @param updateFields The fields to update.
     * @return A CompletableFuture that resolves to the updated custom field.
     */
    public CompletableFuture<ConfigurableCustomField> partialUpdateCustomField(int fieldId, JsonObject updateFields) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + fieldId;
        return connectionManager.patch(endpoint, updateFields, ConfigurableCustomField.class);
    }

    /**
     * Deletes a custom field.
     *
     * @param fieldId The ID of the custom field to delete.
     * @return A CompletableFuture that resolves to a boolean indicating success.
     */
    public CompletableFuture<Boolean> deleteCustomField(int fieldId) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + fieldId;
        return connectionManager.delete(endpoint);
    }

    /**
     * Associates a custom field with a fieldset.
     *
     * @param customFieldId The ID of the custom field to associate.
     * @param fieldsetId The ID of the fieldset to associate the custom field with.
     * @return A CompletableFuture that resolves to a JsonObject representing the association.
     */
    public CompletableFuture<JsonObject> associateCustomFieldWithFieldset(int customFieldId, int fieldsetId) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + customFieldId + "/associate";

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("fieldset_id", fieldsetId);

        return connectionManager.post(endpoint, requestBody, JsonObject.class);
    }

    /**
     * Disassociates a custom field from a fieldset.
     *
     * @param customFieldId The ID of the custom field to disassociate.
     * @param fieldsetId The ID of the fieldset to disassociate the custom field from.
     * @return A CompletableFuture that resolves to a JsonObject representing the disassociation.
     */
    public CompletableFuture<JsonObject> disassociateCustomFieldFromFieldset(int customFieldId, int fieldsetId) {
        String endpoint = CUSTOM_FIELDS_ENDPOINT + "/" + customFieldId + "/disassociate";

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("fieldset_id", fieldsetId);

        return connectionManager.post(endpoint, requestBody, JsonObject.class);
    }
}

