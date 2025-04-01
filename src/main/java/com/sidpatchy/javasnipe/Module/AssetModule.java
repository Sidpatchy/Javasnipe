package com.sidpatchy.javasnipe.Module;

import com.google.gson.JsonArray;
import com.sidpatchy.javasnipe.Bean.Asset.Asset;
import com.sidpatchy.javasnipe.IO.HttpConnectionManager;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AssetModule {

    private final HttpConnectionManager connectionManager;

    public AssetModule(HttpConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Fetches a list of assets with pagination.
     *
     * @param limit  The number of assets per page.
     * @param offset The offset to start fetching assets.
     * @return A CompletableFuture that resolves to a list of assets.
     */
    public CompletableFuture<List<Asset>> fetchAssets(int limit, int offset) {
        String endpoint = "/hardware";
        TypeToken<List<Asset>> type = new TypeToken<>() {};
        return connectionManager.fetchAllPages(endpoint, type.getType(), limit, offset);
    }

    /**
     * Fetches an asset by its ID.
     *
     * @param id The ID of the asset.
     * @return A CompletableFuture that resolves to the asset.
     */
    public CompletableFuture<Asset> fetchAssetById(String id) {
        String endpoint = "/hardware/" + id;
        return connectionManager.get(endpoint, Asset.class);
    }

    /**
     * Fetches an asset by its asset tag.
     *
     * @param assetTag The tag of the asset.
     * @return A CompletableFuture that resolves to the asset.
     */
    public CompletableFuture<Asset> fetchAssetByTag(String assetTag) {
        String endpoint = "/hardware/bytag/" + assetTag;
        return connectionManager.get(endpoint, Asset.class);
    }

    /**
     * Fetches assets by their serial number.
     *
     * @param serialNumber The serial number of the asset.
     * @return A CompletableFuture that resolves to a list of assets.
     */
    public CompletableFuture<List<Asset>> fetchAssetsBySerialNumber(String serialNumber) {
        String endpoint = "/hardware/byserial/" + serialNumber;
        TypeToken<List<Asset>> type = new TypeToken<>() {};
        return connectionManager.fetchAllPages(endpoint, type.getType(), 500, 0);
    }

    /**
     * Creates a new asset.
     *
     * @param asset The asset to create.
     * @return A CompletableFuture that resolves to the created asset.
     */
    public CompletableFuture<Asset> createAsset(Asset asset) {
        String endpoint = "/hardware";
        return connectionManager.post(endpoint, asset, Asset.class);
    }

    /**
     * Updates an existing asset.
     *
     * @param asset The asset with updated information.
     * @return A CompletableFuture that resolves to the updated asset.
     */
    public CompletableFuture<Asset> updateAsset(Asset asset) {
        String endpoint = "/hardware/" + asset.getId().orElseThrow(() -> new IllegalArgumentException("Asset must have an ID"));
        return connectionManager.put(endpoint, asset, Asset.class);
    }

    /**
     * Partially updates an asset.
     *
     * @param assetId      The ID of the asset to update.
     * @param updateFields The fields to update.
     * @return A CompletableFuture that resolves to the updated asset.
     */
    public CompletableFuture<Asset> partialUpdateAsset(int assetId, JsonObject updateFields) {
        String endpoint = "/hardware/" + assetId;
        return connectionManager.patch(endpoint, updateFields, Asset.class);
    }

    /**
     * Deletes an asset.
     *
     * @param assetId The ID of the asset to delete.
     * @return A CompletableFuture that resolves to a boolean indicating success.
     */
    public CompletableFuture<Boolean> deleteAsset(int assetId) {
        String endpoint = "/hardware/" + assetId;
        return connectionManager.delete(endpoint);
    }

    /**
     * Fetches assets that are due for audit.
     *
     * @return A CompletableFuture that resolves to a list of assets due for audit.
     */
    public CompletableFuture<List<Asset>> fetchAssetsDueForAudit() {
        String endpoint = "/hardware/audit/due";
        TypeToken<List<Asset>> type = new TypeToken<>() {};
        return connectionManager.fetchAllPages(endpoint, type.getType(), 500, 0);
    }

    /**
     * Fetches assets that are overdue for audit.
     *
     * @return A CompletableFuture that resolves to a list of assets overdue for audit.
     */
    public CompletableFuture<List<Asset>> fetchAssetsOverdueForAudit() {
        String endpoint = "/hardware/audit/overdue";
        TypeToken<List<Asset>> type = new TypeToken<>() {};
        return connectionManager.fetchAllPages(endpoint, type.getType(), 500, 0);
    }

    /**
     * Generates labels for the specified asset tags.
     *
     * @param assetTags A list of asset tags for which labels need to be generated.
     * @return A CompletableFuture that resolves to a JsonObject containing the generated labels.
     */
    public CompletableFuture<byte[]> generateLabels(List<String> assetTags) {
        String endpoint = "/hardware/labels";
        JsonObject payload = new JsonObject();
        JsonArray tagsArray = new JsonArray();
        assetTags.forEach(tagsArray::add);
        payload.add("asset_tags", tagsArray);

        return connectionManager.postBytes(endpoint, payload);
    }
}

