package com.yolo.utils;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/9
 * Time: 15:27
 */


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonUtil {
    private static ObjectMapper wrapper = new ObjectMapper();

    public JsonUtil() {
    }

    public static String toString(Object json) {
        try {
            return wrapper.writeValueAsString(json);
        } catch (Exception e) {
            throw new RuntimeException("解析json出错", e);
        }
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return wrapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("解析json出错", e);
        }
    }

    public static <T> T toObject(String json, Class<T> clazz, Class... parameterClasses) {
        try {
            return wrapper.readValue(json, wrapper.getTypeFactory().constructParametricType(clazz, parameterClasses));
        } catch (Exception e) {
            throw new RuntimeException("解析json出错", e);
        }
    }

    static {
        wrapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        wrapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, new JsonSerializer<Long>() {
            public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString(String.valueOf(aLong));
            }
        });
        wrapper.registerModule(simpleModule);
    }
}
