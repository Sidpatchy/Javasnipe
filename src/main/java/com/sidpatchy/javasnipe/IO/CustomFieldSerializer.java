package com.sidpatchy.javasnipe.IO;

import com.google.gson.*;
import com.sidpatchy.javasnipe.Bean.CustomField.CustomField;

import java.lang.reflect.Type;
import java.util.Map;

//todo make this CustomFields instead of Map<String, CustomField>
public class CustomFieldSerializer implements JsonSerializer<Map<String, CustomField>> {
    @Override
    public JsonElement serialize(Map<String, CustomField> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        Gson gson = new Gson();
        for (Map.Entry<String, CustomField> entry : src.entrySet()) {
            result.add(entry.getKey(), gson.toJsonTree(entry.getValue()));
        }
        return result;
    }
}
