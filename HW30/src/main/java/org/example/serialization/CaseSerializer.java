package org.example.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Case;

import java.lang.reflect.Type;

public class CaseSerializer implements JsonSerializer<Case> {
    @Override
    public JsonElement serialize(Case aCase, Type type, JsonSerializationContext context) {

        return new JsonPrimitive(aCase.getCaseTitle() + ":" + aCase.getDescription());
    }
}
