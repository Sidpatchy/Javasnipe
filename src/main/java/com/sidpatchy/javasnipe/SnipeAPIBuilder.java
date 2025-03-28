package com.sidpatchy.javasnipe;

@Deprecated
public class SnipeAPIBuilder {
    private String token;
    private String apiEndpoint;

    public SnipeAPIBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public SnipeAPIBuilder setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
        return this;
    }

    public SnipeAPI build() {
        return new SnipeAPI(this.token, apiEndpoint);
    }
}
