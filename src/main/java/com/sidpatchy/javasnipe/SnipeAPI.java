package com.sidpatchy.javasnipe;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sidpatchy.javasnipe.APIObject.Asset.Asset;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SnipeAPI {
    private final Logger logger = LogManager.getLogger();
    private final String token;
    private final String apiEndpoint; // Development endpoint: https://develop.snipeitapp.com/api/v1/
    private final Gson gson = new Gson();

    protected SnipeAPI(String token, String apiEndpoint) {
        this.token = token;
        this.apiEndpoint = apiEndpoint;
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
                if (status != HttpURLConnection.HTTP_OK) {
                    logger.error("Failed to retrieve data: HTTP error " + status);
                    throw new RuntimeException("HTTP error: " + url.toString());
                }
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);
                JsonArray jsonArray = jsonResponse.getAsJsonArray("rows"); // Now targeting the 'rows' array
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
     * @param limit Number of items per page
     * @param offset Starting offset
     * @param sort Sorting field
     * @param order Order of sort (asc or desc)
     * @return CompletableFuture that resolves to a list of all hardware items
     */
    public CompletableFuture<List<Asset>> getHardwareList(int limit, int offset, String sort, String order) {
        String endpoint = "/hardware";
        Type typeOfT = new TypeToken<List<Asset>>(){}.getType(); // Correct use of TypeToken
        return fetchAllPages(endpoint, typeOfT, limit, offset);
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

                // Manually create JSON Object
                JsonObject jsonAsset = new JsonObject();
                jsonAsset.addProperty("asset_tag", asset.getAssetTag());
                jsonAsset.addProperty("model_id", asset.getModel().getId());  // Assuming getModel() returns a Model object with an ID
                jsonAsset.addProperty("status_id", asset.getStatusLabel().getId());  // Assuming getStatusLabel() returns a StatusLabel object with an ID

                // Convert JsonObject to JSON String
                String jsonInput = gson.toJson(jsonAsset);
                logger.info("JSON Payload: " + jsonInput);  // Log the JSON payload to inspect it

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
}
