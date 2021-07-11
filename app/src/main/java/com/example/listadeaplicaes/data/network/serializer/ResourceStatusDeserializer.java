package com.example.listadeaplicaes.data.network.serializer;

import com.example.listadeaplicaes.data.network.Status;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ResourceStatusDeserializer implements JsonDeserializer<Status>{

    @Override
    public Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Status.parse(json.getAsString());
    }
}
