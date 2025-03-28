package com.sidpatchy.javasnipe;

import com.sidpatchy.javasnipe.Bean.Asset.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SnipeAPIIntegrationTest {
    private SnipeAPI snipeAPI;
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMGQzNmRkNjI1N2VlMjEwNjYyNGFjYjIxNmZmMTE0ZDJmNDAzZDI4MWU2YWI1NTdjNDk4ODMyZDc3YjExMmQzMjZkMTAzMGYwYTA1NTc3ZGYiLCJpYXQiOjE3MTQ1MDc1MTEuNjkwNDczLCJuYmYiOjE3MTQ1MDc1MTEuNjkwNDc0LCJleHAiOjIxODc4MDY3MTEuNjg0NjA1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.lP5O_T3hvCKkqeCWV1r-YpIYQUH08HFKr_nnk4Ion8_8zbzLQr9f2DoHkz8_zPJUvqNeCbWTq9o6N7QOGGbuTEmoxLvVd61PQ_lo_rFNHUQXCB5Y6NuHTKBaoktibPsh3IdsqnYFa2KnOFb-4g-VmXPL4menQVdsOvNPBV5IA6S6GAer6yvLDv3lm5O8atVHvBeTJkpHOpWCyLlSiUz1zp_z-oSwcx_DBU-TdT4RHzdkhUq87fqtnjSeo-Kfm8t71f2VYrFRPS-yPvcrU4jHeV2PSRZNZnyvQDPRll4jIhaztmR-39y9DcOxZEe51cBhdSzjwgcDw-6-KiVZwcY8M1T0PTwGPqxh5vO7P7qwjYhoBclaRAxmmlPt2mjTXo5zyhAh3K_X_X2s2EPhrVwuNFKvI4omEqUxJ7Ehl9hsHQSdIw-P8xMr-lIGneL53k_VtDxExpZwgkIbOwqc9PGl1jVAxie_SdftGiTHpZhGPiVDZ5xUfcdYpNwrrLzjCQjlbaVNvponxSM0_beeiD5BzTlA3vmDdLl_T8snHHPACYsfAZVjy8oRpyqUFyuHAnDAwv8TsXm6KFLLlaw3Xsf-UyVbn_lOLM7t2T6HTSL6t3WQGlTsT0m4Sest3rNWLuwPEUl5r-jJEhzfsTjAb3_1xl8aDXzXyOT7LOihFOjpabM";
    private final String apiEndpoint = "http://10.0.0.176/api/v1"; // Use your development API endpoint

    @Test
    public void testGetAssetList() {
        snipeAPI = new SnipeAPIBuilder()
                .setApiEndpoint(apiEndpoint)
                .setToken(token)
                .build();
        CompletableFuture<List<Asset>> futureResult = snipeAPI.getAssetList(10, 0, "id", "asc");
        List<Asset> result = futureResult.join();

        // Check that the list is not empty and contains expected data
        assertNotNull(result);
        assertFalse(result.isEmpty()); // Ensure the result is not empty
        // You can add more detailed checks based on what data is expected, e.g.,
        // assertEquals("ExpectedAssetName", result.get(0).getName());
    }
}
