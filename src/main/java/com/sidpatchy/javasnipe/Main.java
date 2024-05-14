package com.sidpatchy.javasnipe;

import com.google.gson.Gson;
import com.sidpatchy.javasnipe.APIObject.Asset.Asset;
import com.sidpatchy.javasnipe.APIObject.Asset.AssetBuilder;
import com.sidpatchy.javasnipe.APIObject.Asset.Model;
import com.sidpatchy.javasnipe.APIObject.Asset.StatusLabel;
import com.sidpatchy.javasnipe.APIObject.Enum.Order;
import com.sidpatchy.javasnipe.APIObject.Enum.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SnipeAPI api = new SnipeAPIBuilder()
                .setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMGQzNmRkNjI1N2VlMjEwNjYyNGFjYjIxNmZmMTE0ZDJmNDAzZDI4MWU2YWI1NTdjNDk4ODMyZDc3YjExMmQzMjZkMTAzMGYwYTA1NTc3ZGYiLCJpYXQiOjE3MTQ1MDc1MTEuNjkwNDczLCJuYmYiOjE3MTQ1MDc1MTEuNjkwNDc0LCJleHAiOjIxODc4MDY3MTEuNjg0NjA1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.lP5O_T3hvCKkqeCWV1r-YpIYQUH08HFKr_nnk4Ion8_8zbzLQr9f2DoHkz8_zPJUvqNeCbWTq9o6N7QOGGbuTEmoxLvVd61PQ_lo_rFNHUQXCB5Y6NuHTKBaoktibPsh3IdsqnYFa2KnOFb-4g-VmXPL4menQVdsOvNPBV5IA6S6GAer6yvLDv3lm5O8atVHvBeTJkpHOpWCyLlSiUz1zp_z-oSwcx_DBU-TdT4RHzdkhUq87fqtnjSeo-Kfm8t71f2VYrFRPS-yPvcrU4jHeV2PSRZNZnyvQDPRll4jIhaztmR-39y9DcOxZEe51cBhdSzjwgcDw-6-KiVZwcY8M1T0PTwGPqxh5vO7P7qwjYhoBclaRAxmmlPt2mjTXo5zyhAh3K_X_X2s2EPhrVwuNFKvI4omEqUxJ7Ehl9hsHQSdIw-P8xMr-lIGneL53k_VtDxExpZwgkIbOwqc9PGl1jVAxie_SdftGiTHpZhGPiVDZ5xUfcdYpNwrrLzjCQjlbaVNvponxSM0_beeiD5BzTlA3vmDdLl_T8snHHPACYsfAZVjy8oRpyqUFyuHAnDAwv8TsXm6KFLLlaw3Xsf-UyVbn_lOLM7t2T6HTSL6t3WQGlTsT0m4Sest3rNWLuwPEUl5r-jJEhzfsTjAb3_1xl8aDXzXyOT7LOihFOjpabM")
                .setApiEndpoint("http://10.0.0.176/api/v1")
                .build();

        // Get all assets, then get the first asset in the list.
        Asset asset = api.getAssetBySerialNumber("1GBDZW2").join().get(0);

        // Get all assets, then get the asset tag of the first asset in the list.
        String assetTag = asset.getAssetTag();
        logger.info("Asset Tag: {}", assetTag);

        // Get the asset's serial number.
        String serialNumber = asset.getSerial().orElse("");
        logger.info("Serial Number: {}", serialNumber);

        //logger.info(asset.getCustomFields().orElse(null).getFields().toString());
    }
}
