package com.ruoyi.erweima.commm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(String json) {
        try {
            return objectMapper.readValue(json, HashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON反序列化失败: " + e.getMessage(), e);
        }
    }
}