package com.sidpatchy.javasnipe;

import com.sidpatchy.javasnipe.IO.HttpConnectionManager;
import com.sidpatchy.javasnipe.Module.AssetModule;
import com.sidpatchy.javasnipe.Module.CustomFieldModule;
import com.sidpatchy.javasnipe.Module.LicenseModule;

public class SnipeClient {

    private final AssetModule assetModule;
    private final CustomFieldModule customFieldModule;
    //private final LicenseModule licenseModule;

    public SnipeClient(String token, String apiEndpoint) {
        HttpConnectionManager connectionManager = new HttpConnectionManager(token, apiEndpoint);

        this.assetModule = new AssetModule(connectionManager);
        this.customFieldModule = new CustomFieldModule(connectionManager);
        //this.licenseModule = new LicenseModule(connectionManager);
    }

    public AssetModule getAssets() {
        return assetModule;
    }

    public CustomFieldModule getCustomFields() {
        return customFieldModule;
    }

    //public LicenseModule getLicenses() {
    //    return licenseModule;
    //}

    // Fluent method to start the API
    public SnipeClient connect() {
        // Initialize connections or perform any startup logic here
        return this;
    }

    // Add methods to add event listeners, etc., if needed
}

