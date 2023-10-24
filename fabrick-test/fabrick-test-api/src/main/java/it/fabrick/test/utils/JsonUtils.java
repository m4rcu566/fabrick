package it.fabrick.test.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Object stringToObject(String json, Class input, String primaryJsonFiled) throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper = getObjectMapper();
        JSONObject content = new JSONObject(json);
        String entity = content.getJSONObject(primaryJsonFiled).toString();
        return objectMapper.readValue(entity, input);
    }
    public static String stringToString(String json, String primaryJsonFiled) throws JsonProcessingException, JSONException {
        JSONObject content = new JSONObject(json);
        String entity = content.getJSONObject(primaryJsonFiled).toString();
        return entity;
    }

    public static Object stringToObjectArray(String json, Class input, String primaryJsonFiled) throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper = getObjectMapper();
        JSONObject content = new JSONObject(json);
        String entity = content.getJSONArray(primaryJsonFiled).toString();
        return objectMapper.readValue(entity, input);
    }

    private static ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return objectMapper;
    }

}
