package com.sidpatchy.javasnipe;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sidpatchy.javasnipe.APIObject.Asset.Asset;
import com.sidpatchy.javasnipe.APIObject.Asset.StatusLabel;
import com.sidpatchy.javasnipe.APIObject.Enum.*;
import com.sidpatchy.javasnipe.APIObject.Generic.CustomField;
import com.sidpatchy.javasnipe.APIObject.Generic.CustomFields;
import com.sidpatchy.javasnipe.APIObject.Generic.Location;
import com.sidpatchy.javasnipe.APIObject.License.License;
import com.sidpatchy.javasnipe.APIObject.Person.Person;
import com.sidpatchy.javasnipe.IO.CustomFieldDeserializer;
import com.sidpatchy.javasnipe.IO.CustomFieldSerializer;
import jdk.jshell.SourceCodeAnalysis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SnipeAPI {
    private final Logger logger = LogManager.getLogger();
    private final String token;
    private final String apiEndpoint; // Development endpoint: https://develop.snipeitapp.com/api/v1/
    private final Gson gson;

    protected SnipeAPI(String token, String apiEndpoint) {
        this.token = token;
        this.apiEndpoint = apiEndpoint;
        this.gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(new TypeToken<CustomFields>(){}.getType(), new CustomFieldSerializer())
                .registerTypeAdapter(new TypeToken<CustomFields>(){}.getType(), new CustomFieldDeserializer())
                .create();

    }

    /**
     * Sets up a HttpURLConnection with the specified URL and method.
     *
     * @param url the URL to connect to
     * @param method the HTTP method to use
     * @return the HttpURLConnection object
     * @throws IOException if an I/O error occurs while opening the connection
     */
    private HttpURLConnection setupHttpURLConnection(URL url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + this.token);
        connection.setConnectTimeout(10000); // 10 seconds connect timeout
        connection.setReadTimeout(10000); // 10 seconds read timeout
        if ("POST".equals(method) || "PUT".equals(method)) {
            connection.setDoOutput(true); // Necessary for POST and PUT
        }
        return connection;
    }

    /**
     * Retrieves data from an API asynchronously and deserializes it into the specified type.
     *
     * @param endpoint the endpoint of the API
     * @param typeOfT  the type of the data to retrieve
     * @return a CompletableFuture that resolves to a List of the retrieved data of type T
     */
    public <T> CompletableFuture<List<T>> getFromAPI(String endpoint, Type typeOfT) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "GET");
                int status = connection.getResponseCode();
                System.out.println("HTTP Status: " + status);  // Log the status

                if (status != HttpURLConnection.HTTP_OK) {
                    logger.error("Failed to retrieve data: HTTP error " + status);
                    throw new RuntimeException("HTTP error: " + url.toString());
                }

                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);
                System.out.println("Raw JSON Response: " + jsonResponse);  // Log the raw JSON

                JsonArray jsonArray = jsonResponse.getAsJsonArray("rows");
                List<T> result = gson.fromJson(jsonArray, typeOfT);
                reader.close();
                return result;
            } catch (Exception e) {
                logger.error("Error fetching data from API", e);
                throw new RuntimeException(e);
            }
        }, CompletableFuture.delayedExecutor(0, TimeUnit.MILLISECONDS, Executors.newCachedThreadPool()));
    }


    /**
     * Recursively fetches all pages of data from the API.
     *
     * @param endpoint The endpoint with parameters
     * @param typeOfT The type of the data to retrieve
     * @param limit The number of items per page
     * @param offset The current offset
     * @return CompletableFuture that resolves to a list of all fetched data
     */
    private <T> CompletableFuture<List<T>> fetchAllPages(String endpoint, Type typeOfT, int limit, int offset) {
        // This is the base URL for fetching pages. The offset will be updated with each recursive call.
        String pageUrl = endpoint + "?limit=" + limit + "&offset=" + offset;

        return getFromAPI(pageUrl, typeOfT).thenCompose(result -> {
            List<T> currentPage = (List<T>) new ArrayList<>(result);

            // If the current page is not full, it's the last page.
            if (currentPage.size() < limit) {
                return CompletableFuture.completedFuture(currentPage);
            } else {
                // Prepare the next page's URL.
                int nextOffset = offset + limit;
                // Recursively call fetchAllPages to get the next page's results.
                return fetchAllPages(endpoint, typeOfT, limit, nextOffset)
                        .thenApply(nextPage -> {
                            // Combine the current page with the next page.
                            currentPage.addAll((Collection<? extends T>) nextPage);
                            return currentPage;
                        });
            }
        }).exceptionally(ex -> {
            // Log and handle exceptions.
            logger.error("Error fetching paginated results", ex);
            throw new RuntimeException("Error fetching paginated results", ex);
        });
    }

    /**
     * Fetches the hardware list from the API with pagination.
     *
     * @param sort Sorting field
     * @param order Order of sort (asc or desc)
     * @return CompletableFuture that resolves to a list of all hardware items
     */
    public CompletableFuture<List<Asset>> getAssetList(Sort sort, Order order) {
        String endpoint = "/hardware";
        Type typeOfT = new TypeToken<List<Asset>>(){}.getType();
        return fetchAllPages(endpoint, typeOfT, 500, 0);
    }

    /**
     * Fetches details of a specific hardware item based on a specified identifier.
     * <p>
     * {@link SnipeAPI#getAssetByID(String)}, {@link SnipeAPI#getAssetByTag(java.lang.String)}, and
     * {@link SnipeAPI#getAssetBySerialNumber(String)} are provided for simplicity and readability.
     *
     * @param identifierType the type of identifier (id, asset_tag, serial)
     * @param identifierValue the value of the identifier
     * @return a CompletableFuture that resolves to the specified hardware Asset
     */
    public CompletableFuture<Asset> getAssetByIdentifier(AssetIdentifier identifierType, String identifierValue) {
        String endpoint = switch (identifierType) {
            case ID -> "/hardware/" + identifierValue;  // Access by hardware ID
            case ASSET_TAG -> "/hardware/bytag/" + identifierValue;  // Access by asset tag
        };

        Type typeOfT = new TypeToken<Asset>(){}.getType(); // Correct use of TypeToken for a single Asset object

        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "GET");
                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    logger.error("Failed to retrieve hardware: HTTP error " + status);
                    throw new RuntimeException("HTTP error: " + url.toString());
                }
                InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                Asset result = gson.fromJson(reader, Asset.class);
                reader.close();
                return result;
            } catch (Exception e) {
                logger.error("Error fetching hardware details from API", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Retrieves an asset asynchronously by its ID.
     *
     * @param assetID the ID of the asset (NOT Asset Tag)
     * @return a CompletableFuture that resolves to the retrieved asset
     */
    public CompletableFuture<Asset> getAssetByID(String assetID) {
        return getAssetByIdentifier(AssetIdentifier.ID, assetID);
    }

    /**
     * Retrieves an asset by its asset tag.
     *
     * @param assetTag the tag of the asset
     * @return a CompletableFuture that resolves to the specified asset identified by the tag
     */
    public CompletableFuture<Asset> getAssetByTag(String assetTag) {
        return getAssetByIdentifier(AssetIdentifier.ASSET_TAG, assetTag);
    }

    /**
     * Retrieves an asset by its serial number.
     *
     * @param assetSerialNumber the serial number of the asset
     * @return a CompletableFuture that resolves to the asset with the specified serial number
     */
    public CompletableFuture<List<Asset>> getAssetBySerialNumber(String assetSerialNumber) {
        String endpoint = "/hardware/byserial/" + assetSerialNumber;
        Type typeOfT = new TypeToken<List<Asset>>(){}.getType(); // Correct use of TypeToken
        return fetchAllPages(endpoint, typeOfT, 500, 0);
    }

    /**
     * Fetches a list of assets that are due for audit or overdue for audit.
     *
     * @param auditType Type of audit ({@code AuditType.DUE} for audit due or {@code AuditType.OVERDUE} for audit overdue)
     * @return CompletableFuture that resolves to a list of all hardware items needing audit
     */
    public CompletableFuture<List<Asset>> getAssetAudit(AuditType auditType) {
        String endpoint = "/hardware/audit/" + auditType; // Constructs the endpoint dynamically
        Type typeOfT = new TypeToken<List<Asset>>(){}.getType(); // Assuming Asset class can hold all necessary properties

        return fetchAllPages(endpoint, typeOfT, 500, 0);
    }

    /**
     * Retrieves a list of assets that are due for audit.
     *
     * @return a CompletableFuture that resolves to a list of assets needing audit
     */
    public CompletableFuture<List<Asset>> getAssetsDueForAudit() {
        return getAssetAudit(AuditType.DUE);
    }

    /**
     * Retrieves a list of assets that are overdue for audit.
     *
     * @return a CompletableFuture that resolves to a list of all hardware items needing audit
     */
    public CompletableFuture<List<Asset>> getAssetsOverdueForAudit() {
        return getAssetAudit(AuditType.OVERDUE);
    }

    /**
     * Fetches a list of licenses associated with a given asset ID.
     *
     * @param asset asset whose licenses are to be fetched.
     * @return CompletableFuture that resolves to a list of licenses associated with the specified hardware
     */
    public CompletableFuture<List<License>> getAssetLicensesByID(Asset asset) {
        int assetID = asset.getId().orElse(-1);

        if (assetID < 0) {
            throw new IllegalArgumentException("Asset must be retrieved from API. AssetBuilder is not supported.");
        }

        String endpoint = "/hardware/" + assetID + "/licenses"; // Constructing the endpoint
        Type typeOfT = new TypeToken<List<License>>(){}.getType(); // Correct use of TypeToken for a list of License objects

        return fetchAllPages(endpoint, typeOfT, 500, 0);
    }

    /**
     * Creates an asset by sending a POST request to the API endpoint.
     *
     * @param asset the asset to create
     * @return a CompletableFuture that resolves to the created asset
     */
    public CompletableFuture<Asset> createAsset(Asset asset) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + "/hardware");
                HttpURLConnection connection = setupHttpURLConnection(url, "POST");

                // Create a JsonObject from the asset using GSON
                JsonObject jsonAsset = gson.toJsonTree(asset).getAsJsonObject();

                // Ensure critical fields are explicitly set
                jsonAsset.addProperty("asset_tag", asset.getAssetTag());
                jsonAsset.addProperty("model_id", asset.getModel().getId().orElse(-1));
                jsonAsset.addProperty("status_id", asset.getStatusLabel().getId().orElse(-1));

                // Convert JsonObject to JSON String
                String jsonInput = gson.toJson(jsonAsset);
                logger.info("JSON Payload: " + jsonInput);

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                    Asset responseAsset = gson.fromJson(reader, Asset.class);
                    logger.info(gson.toJson(responseAsset));
                    reader.close();
                    return responseAsset;
                } else {
                    String errorMessage = "Failed to create asset: HTTP error code " + status;
                    logger.error(errorMessage);
                    throw new RuntimeException(errorMessage);
                }
            } catch (IOException e) {
                logger.error("Error when attempting to create asset", e);
                throw new RuntimeException("Network error when attempting to create asset", e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Updates a hardware asset fully by sending a PUT request with the entire asset data.
     *
     * @param asset the updated asset object
     * @return CompletableFuture that resolves to the updated asset
     */
    public CompletableFuture<Asset> updateAsset(Asset asset) {
        int hardwareId = asset.getId().orElse(-1);

        if (hardwareId < 0) {
            throw new IllegalArgumentException("Asset must be retrieved from API. AssetBuilder is not supported.");
        }

        String endpoint = "/hardware/" + hardwareId; // API endpoint
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "PUT");

                JsonObject jsonAsset = gson.toJsonTree(asset).getAsJsonObject();
                String jsonInput = gson.toJson(jsonAsset);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    logger.error("Failed to update hardware: HTTP error " + status);
                    throw new RuntimeException("Failed to update hardware: HTTP error " + status);
                }
                InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                Asset responseAsset = gson.fromJson(reader, Asset.class);
                reader.close();
                return responseAsset;
            } catch (Exception e) {
                logger.error("Error updating hardware", e);
                throw new RuntimeException("Error updating hardware", e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Partially updates a hardware asset by sending a PATCH request with the specific fields that need to be updated.
     * <p>
     * You most likely want {@link SnipeAPI#updateAsset(Asset)}
     *
     * @param hardwareId the ID of the hardware to update
     * @param updateFields the JsonObject containing only the fields to update
     * @return CompletableFuture that resolves to the updated asset
     */
    public CompletableFuture<Asset> partialUpdateAsset(int hardwareId, JsonObject updateFields) {
        String endpoint = "/hardware/" + hardwareId; // API endpoint
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "PATCH");

                String jsonInput = gson.toJson(updateFields);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    logger.error("Failed to partially update hardware: HTTP error " + status);
                    throw new RuntimeException("Failed to partially update hardware: HTTP error " + status);
                }
                InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                Asset responseAsset = gson.fromJson(reader, Asset.class);
                reader.close();
                return responseAsset;
            } catch (Exception e) {
                logger.error("Error partially updating hardware", e);
                throw new RuntimeException("Error partially updating hardware", e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Deletes a hardware asset.
     *
     * @param asset the Asset to delete
     * @return CompletableFuture that resolves to a boolean indicating success or failure
     */
    public CompletableFuture<Boolean> deleteHardware(Asset asset) {
        String assetID = asset.getAssetTag();

        String endpoint = "/hardware/" + assetID; // API endpoint
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "DELETE");
                int status = connection.getResponseCode();
                return status == HttpURLConnection.HTTP_OK;
            } catch (Exception e) {
                logger.error("Error deleting hardware", e);
                throw new RuntimeException("Error deleting hardware", e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Performs an action on a hardware asset asynchronously.
     *
     * @param asset the asset to perform the action on
     * @param action the action to be performed on the hardware asset
     * @param details additional details or parameters required for the action (can be null)
     * @return a CompletableFuture that resolves to the asset after the action has been performed
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    protected CompletableFuture<Asset> performAssetAction(Asset asset, AssetAction action, JsonObject details) {
        int hardwareId = asset.getId().orElse(-1);

        if (hardwareId < 0) {
            throw new IllegalArgumentException("Asset must be retrieved from API. AssetBuilder is not supported.");
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                String urlEndpoint = apiEndpoint + "/hardware/" + hardwareId + "/" + action.toString();
                URL url = new URL(urlEndpoint);
                HttpURLConnection connection = setupHttpURLConnection(url, "POST");

                if (details != null) {
                    String jsonInput = gson.toJson(details);
                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }
                }

                int status = connection.getResponseCode();
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                    Asset responseAsset = gson.fromJson(reader, Asset.class);
                    reader.close();
                    return responseAsset;
                } else {
                    throw new RuntimeException("Failed operation: HTTP error " + status);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error during hardware operation: " + action, e);
            }
        }, Executors.newCachedThreadPool());
    }

    public CompletableFuture<Asset> checkoutToAsset(Asset assetToCheckout, Asset assetToCheckoutTo) {
        JsonObject details = new JsonObject();
        assetToCheckoutTo.getId().ifPresentOrElse(
                id -> details.addProperty("target_asset_id", id),
                () -> { throw new IllegalArgumentException("Target asset must have an ID."); }
        );

        return performAssetAction(assetToCheckout, AssetAction.CHECKOUT, details);
    }

    public CompletableFuture<Asset> checkoutToPerson(Asset assetToCheckout, Person personToCheckoutTo) {
        JsonObject details = new JsonObject();
        // Assuming Person class has a method getId() that returns an Optional<Integer>
        personToCheckoutTo.getId().ifPresentOrElse(
                id -> details.addProperty("user_id", id),
                () -> { throw new IllegalArgumentException("Person must have an ID."); }
        );

        return performAssetAction(assetToCheckout, AssetAction.CHECKOUT, details);
    }

    public CompletableFuture<Asset> checkoutToLocation(Asset assetToCheckout, Location locationToCheckoutTo) {
        JsonObject details = new JsonObject();
        // Assuming Location class has a method getId() that returns an Optional<Integer>
        locationToCheckoutTo.getId().ifPresentOrElse(
                id -> details.addProperty("location_id", id),
                () -> { throw new IllegalArgumentException("Location must have an ID."); }
        );

        return performAssetAction(assetToCheckout, AssetAction.CHECKOUT, details);
    }

    /**
     * Checks in a hardware asset asynchronously.
     *
     * @param assetToCheckIn the asset being checked in
     * @param status the new status of the asset upon check-in
     * @param location the location to which the asset is being checked in
     * @param note optional note about the check-in
     * @return a CompletableFuture that resolves to the asset after it has been checked in
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    public CompletableFuture<Asset> checkInAsset(Asset assetToCheckIn, StatusLabel status, Location location, String note) {
        JsonObject details = new JsonObject();

        // Add the status ID to the request if status is provided
        if (status != null) {
            status.getId().ifPresentOrElse(
                    id -> details.addProperty("status_id", id),
                    () -> { throw new IllegalArgumentException("Status must have an ID."); }
            );
        }

        // Add the location ID to the request if location is provided
        if (location != null) {
            location.getId().ifPresentOrElse(
                    id -> details.addProperty("location_id", id),
                    () -> { throw new IllegalArgumentException("Location must have an ID."); }
            );
        }

        // Add a note if it is provided and not empty
        if (note != null && !note.isEmpty()) {
            details.addProperty("note", note);
        }

        return performAssetAction(assetToCheckIn, AssetAction.CHECKIN, details);
    }

    /**
     * Checks in a hardware asset asynchronously.
     *
     * @param assetToCheckIn the asset being checked in
     * @param status the new status of the asset upon check-in
     * @param location the location to which the asset is being checked in
     * @return a CompletableFuture that resolves to the asset after it has been checked in
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    public CompletableFuture<Asset> checkInAsset(Asset assetToCheckIn, StatusLabel status, Location location) {
        return checkInAsset(assetToCheckIn, status, location, "");
    }

    /**
     * Checks in a hardware asset asynchronously.
     *
     * @param assetToCheckIn the asset being checked in
     * @param status the new status of the asset upon check-in
     * @param note note about the check-in
     * @return a CompletableFuture that resolves to the asset after it has been checked in
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    public CompletableFuture<Asset> checkInAsset(Asset assetToCheckIn, StatusLabel status, String note) {
        return checkInAsset(assetToCheckIn, status, null, note);
    }

    /**
     * Checks in a hardware asset asynchronously.
     *
     * @param assetToCheckIn the asset being checked in
     * @param status the new status of the asset upon check-in
     * @return a CompletableFuture that resolves to the asset after it has been checked in
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    public CompletableFuture<Asset> checkInAsset(Asset assetToCheckIn, StatusLabel status) {
        return checkInAsset(assetToCheckIn, status, null, "");
    }

    /**
     * Restores a previously deleted hardware asset asynchronously.
     *
     * @param assetToRestore the asset to be restored
     * @return a CompletableFuture that resolves to the restored asset
     * @throws RuntimeException if an error occurs during the hardware operation
     */
    public CompletableFuture<Asset> restoreAsset(Asset assetToRestore) {
        JsonObject details = new JsonObject();

        return performAssetAction(assetToRestore, AssetAction.RESTORE, details);
    }
}
