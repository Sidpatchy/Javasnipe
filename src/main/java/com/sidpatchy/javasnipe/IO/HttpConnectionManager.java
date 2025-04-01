package com.sidpatchy.javasnipe.IO;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
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

public class HttpConnectionManager {

    private final Logger logger = LogManager.getLogger();
    private final String token;
    private final String apiEndpoint;
    private final Gson gson;

    public HttpConnectionManager(String token, String apiEndpoint) {
        this.token = token;
        this.apiEndpoint = apiEndpoint;
        this.gson = new Gson(); // Customize the Gson instance if needed
    }

    /**
     * Sets up a HttpURLConnection with the specified URL and method.
     *
     * @param url the URL to connect to
     * @param method the HTTP method to use
     * @return the HttpURLConnection object
     * @throws Exception if an error occurs while opening the connection
     */
    private HttpURLConnection setupConnection(URL url, String method) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + this.token);
        connection.setConnectTimeout(10000); // 10 seconds connect timeout
        connection.setReadTimeout(10000); // 10 seconds read timeout
        if ("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) {
            connection.setDoOutput(true); // Necessary for POST, PUT, and PATCH
        }
        return connection;
    }

    /**
     * Executes a GET request and parses the response into the specified type.
     *
     * @param endpoint the API endpoint
     * @param typeOfT  the type of the data to parse the response into
     * @return a CompletableFuture that resolves to the parsed response
     */
    public <T> CompletableFuture<T> get(String endpoint, Type typeOfT) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupConnection(url, "GET");
                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("HTTP error " + status);
                }
                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
                    return gson.fromJson(reader, typeOfT);
                }
            } catch (Exception e) {
                logger.error("Error during GET request", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Executes a POST request with the provided data and parses the response into the specified type.
     *
     * @param endpoint the API endpoint
     * @param data the data to send in the POST request
     * @param typeOfT the type of the data to parse the response into
     * @return a CompletableFuture that resolves to the parsed response
     */
    public <T> CompletableFuture<T> post(String endpoint, Object data, Type typeOfT) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupConnection(url, "POST");

                String jsonInput = gson.toJson(data);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("HTTP error " + status);
                }
                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
                    return gson.fromJson(reader, typeOfT);
                }
            } catch (Exception e) {
                logger.error("Error during POST request", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Executes a POST request to the specified endpoint with the provided JSON payload,
     * returning the raw response as a byte array.
     *
     * @param endpoint the API endpoint to which the POST request is sent
     * @param payload the JSON payload to include in the POST request
     * @return a CompletableFuture that resolves to the raw byte array response
     */
    public CompletableFuture<byte[]> postBytes(String endpoint, JsonObject payload) {
        return CompletableFuture.supplyAsync(() -> {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(apiEndpoint + endpoint);
                connection = setupConnection(url, "POST");

                // Write JSON payload
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(gson.toJson(payload).getBytes(StandardCharsets.UTF_8));
                }

                // Handle error responses properly
                int status = connection.getResponseCode();
                if (status >= 400) {
                    String errorBody = readStream(connection.getErrorStream());
                    throw new RuntimeException("HTTP Error " + status + ": " + errorBody);
                }

                // Read raw bytes for successful responses
                return readBytes(connection.getInputStream());

            } catch (Exception e) {
                logger.error("Error during POST request for bytes", e);
                throw new RuntimeException(e);
            } finally {
                if (connection != null) connection.disconnect();
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Reads all bytes from the provided input stream and returns them as a byte array.
     *
     * @param inputStream the input stream to read data from
     * @return a byte array containing all the bytes read from the input stream
     * @throws IOException if an I/O error occurs while reading from the input stream
     */
    private byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new  ByteArrayOutputStream();
        byte[] data = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }

    /**
     * Reads all content from the provided InputStream and converts it into a String.
     *
     * @param inputStream the InputStream to read from
     * @return the content of the InputStream as a String
     * @throws IOException if an I/O error occurs during reading
     */
    private String readStream(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    /**
     * Executes a PUT request with the provided data and parses the response into the specified type.
     *
     * @param endpoint the API endpoint
     * @param data the data to send in the PUT request
     * @param typeOfT the type of the data to parse the response into
     * @return a CompletableFuture that resolves to the parsed response
     */
    public <T> CompletableFuture<T> put(String endpoint, Object data, Type typeOfT) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupConnection(url, "PUT");

                String jsonInput = gson.toJson(data);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("HTTP error " + status);
                }
                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
                    return gson.fromJson(reader, typeOfT);
                }
            } catch (Exception e) {
                logger.error("Error during PUT request", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Executes a DELETE request and returns a CompletableFuture that resolves to a boolean indicating success.
     *
     * @param endpoint the API endpoint
     * @return a CompletableFuture that resolves to a boolean indicating success
     */
    public CompletableFuture<Boolean> delete(String endpoint) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupConnection(url, "DELETE");

                int status = connection.getResponseCode();
                return status == HttpURLConnection.HTTP_OK;
            } catch (Exception e) {
                logger.error("Error during DELETE request", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Executes a PATCH request with the provided data and parses the response into the specified type.
     *
     * @param endpoint the API endpoint
     * @param data the data to send in the PATCH request
     * @param typeOfT the type of the data to parse the response into
     * @return a CompletableFuture that resolves to the parsed response
     */
    public <T> CompletableFuture<T> patch(String endpoint, Object data, Type typeOfT) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(apiEndpoint + endpoint);
                HttpURLConnection connection = setupConnection(url, "PATCH");

                String jsonInput = gson.toJson(data);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("HTTP error " + status);
                }
                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
                    return gson.fromJson(reader, typeOfT);
                }
            } catch (Exception e) {
                logger.error("Error during PATCH request", e);
                throw new RuntimeException(e);
            }
        }, Executors.newCachedThreadPool());
    }

    /**
     * Fetches all pages of data from a paginated API endpoint.
     *
     * @param endpoint the API endpoint
     * @param typeOfT the type of the data to parse the response into
     * @param limit the number of items per page
     * @param offset the current offset
     * @return a CompletableFuture that resolves to a list of the parsed data
     */
    public <T> CompletableFuture<List<T>> fetchAllPages(String endpoint, Type typeOfT, int limit, int offset) {
        String pageUrl = endpoint + "?limit=" + limit + "&offset=" + offset;

        return get(pageUrl, typeOfT).thenCompose(currentPage -> {
            if (((List<?>) currentPage).size() < limit) {
                return CompletableFuture.completedFuture((List<T>) currentPage);
            } else {
                int nextOffset = offset + limit;
                return fetchAllPages(endpoint, typeOfT, limit, nextOffset).thenApply(nextPage -> {
                    List<T> combined = new ArrayList<>((List<T>) currentPage);
                    combined.addAll((Collection<? extends T>) nextPage);
                    return combined;
                });
            }
        });
    }
}

