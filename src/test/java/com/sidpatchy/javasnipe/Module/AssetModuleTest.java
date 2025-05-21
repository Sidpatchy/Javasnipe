package com.sidpatchy.javasnipe.Module;

import com.sidpatchy.javasnipe.Bean.Asset.Asset;
import com.sidpatchy.javasnipe.SnipeClient;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

public class AssetModuleTest {
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNWNiNzg3OTEwNGJiZmVlZDZjMzU0OTI4NDdmZTllZjA5ZDVmNTk2NDc2YmNjYjQwMTg1NGJmYWIxYTljNDFiOTJjZTE4YWNiOTVjMWY1MzQiLCJpYXQiOjE3NDc4NjA5ODcuNzgzOTQ4LCJuYmYiOjE3NDc4NjA5ODcuNzgzOTUsImV4cCI6MjIyMTI0NjU4Ny43Nzk3NjYsInN1YiI6IjEiLCJzY29wZXMiOltdfQ.QHDHeRmIuPwQysZSrQTOWAYuW0r3lm6JHHYW1czKE-VqFrVFk9i_34bnqS6v_FzGfEaMGkMvUbvFL815v7drCJD-YcB6BlVkpCqmrPOuCfAzgrpLnKy1MfIKatMli1juqYfCQRcZlmWc9xn_zwxlcLD7bdHT4LM-pwz2iLqK7HhJrdpq8wqmT-ru0Hgne8KZ3Jwwv_AWZ-13fPYpI5nXd2qePO7hCpZly6ywU19UNk-5Gnx9gai_-BvN8TMBFG60eXTDrnydNlTafj7xvmfwZHB3HXG8g8yCy_3T4CbRhE_BZQIA2gD33bGBJ6zqUlhq3lT61gW7uXsJYcexe9EfPEYgsMh3fxjXqaTGqiE8zMSWA_U7Ev1Ety7dOhYg-OH9W0nonDPkEMUHKCPquG87_MbB2O6AhPhmgw9-yM2-YfNazPHJqBSXhDoOvKeZD9qx9_bfG2lTGLpbPsniAq9Zew0rXl-cyuSSxbSgeLzIZrrvTgS7dQQDuijECcJw4AgAd3ucrpaNp_RFIElwcg1rZqG7EN3Eh2AaeyHRnLr3XwprK5-x6u-pl3Y8HHQVXnUC0fgLtDYmp9xPaV8SP5fKIEKpWACA4hVZ20PaqxCM2Toq68vPOVAoxujD90uFqXz-ohtF_QckCY1lrj4T7JePqjjBM4xk3fobg5_IkbzUgh4";
    private final String apiEndpoint = "http://10.0.0.61/api/v1"; // Use your development API endpoint

    @Test
    public void testFetchAssets() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<List<Asset>> futureResult = client.getAssets().fetchAssets(100,0);
        List<Asset> result = futureResult.join();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFetchAssetById() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<Asset> futureResult = client.getAssets().fetchAssetById("1");
        Asset result = futureResult.join();

        assertNotNull(result);
    }

    @Test
    public void testFetchAssetByTag() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<Asset> futureResult = client.getAssets().fetchAssetByTag("CORPIT08");
        Asset result = futureResult.join();

        assertNotNull(result);
    }

    @Test
    public void testFetchAssetsBySerialNumber() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<List<Asset>> futureResult = client.getAssets().fetchAssetsBySerialNumber("B4T4DL3");
        List<Asset> result = futureResult.join();

        assertNotNull(result);
    }

    @Test
    public void testFetchAssetsDueForAudit() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<List<Asset>> futureResult = client.getAssets().fetchAssetsDueForAudit();
        List<Asset> result = futureResult.join();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFetchAssetsOverdueForAudit() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<List<Asset>> futureResult = client.getAssets().fetchAssetsOverdueForAudit();
        List<Asset> result = futureResult.join();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGenerateLabels() {
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        CompletableFuture<byte[]> futureResult = client.getAssets().generateLabels(List.of("CORPIT08"));
        byte[] result = futureResult.join();

        assertNotNull(result);
        assertNotEquals(0, result.length);
    }
}
