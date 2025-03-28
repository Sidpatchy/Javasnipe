package com.sidpatchy.javasnipe.Bean.Enum;

public enum AssetIdentifier {
    ID("id"),
    ASSET_TAG("asset_Tag");

    private final String identifier;

    AssetIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
