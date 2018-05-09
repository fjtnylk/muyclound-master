package com.muyclound.external.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.muyclound.external.model.Response;
import java.io.IOException;

/**
 * Created by yanglikai on 2018/3/16.
 */
public final class JSONUtils {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private JSONUtils() {
  }

  public static String toJson(Object object) {
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T toBean(String json, Class<T> clazz) {
    try {
      return OBJECT_MAPPER.readValue(json, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T toBean(String json, TypeReference<T> ref) {
    try {
      return OBJECT_MAPPER.readValue(json, ref);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T toClassBean(String json, Class clazz) {
    try {
      JavaType type = OBJECT_MAPPER.getTypeFactory().constructParametricType(Response.class, new Class[]{clazz});
      return OBJECT_MAPPER.readValue(json, type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  static {
    OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    OBJECT_MAPPER.setDateFormat(new MySimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    SimpleModule simpleModule = new SimpleModule("BooleanConvertModule");
    simpleModule.addDeserializer(Boolean.class, new MyNumberDeserializers.BooleanDeserializer(Boolean.class, Boolean.FALSE));
    OBJECT_MAPPER.registerModule(simpleModule);
    OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    OBJECT_MAPPER.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    OBJECT_MAPPER.setPropertyNamingStrategy(new PropertyNamingStrategy.SnakeCaseStrategy());
  }
}
