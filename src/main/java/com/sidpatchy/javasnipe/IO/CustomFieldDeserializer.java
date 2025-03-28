package com.sidpatchy.javasnipe.IO;

import com.google.gson.*;
import com.sidpatchy.javasnipe.Bean.CustomField.CustomField;
import com.sidpatchy.javasnipe.Bean.CustomField.CustomFields;

import java.lang.reflect.Type;
import java.util.Map;

public class CustomFieldDeserializer implements JsonDeserializer<CustomFields> {
    @Override
    public CustomFields deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        CustomFields fields = new CustomFields();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            CustomField field = context.deserialize(entry.getValue(), CustomField.class);
            fields.put(key, field);
        }
        return fields;
    }
}


