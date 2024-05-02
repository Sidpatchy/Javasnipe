package com.sidpatchy.javasnipe.IO;

import com.google.gson.*;
import com.sidpatchy.javasnipe.APIObject.Generic.CustomField;

import java.lang.reflect.Type;
import java.util.Map;

public class CustomFieldSerializer implements JsonSerializer<Map<String, CustomField>> {
    @Override
    public JsonElement serialize(Map<String, CustomField> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        Gson gson = new Gson();
        for (Map.Entry<String, CustomField> entry : src.entrySet()) {
            System.out.println("Serializing Key: " + entry.getKey() + " Value: " + entry.getValue());
            result.add(entry.getKey(), gson.toJsonTree(entry.getValue()));
        }
        return result;
    }
}
