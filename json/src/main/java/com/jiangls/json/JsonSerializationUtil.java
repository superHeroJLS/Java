package com.jiangls.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

/**
 * <p>
 *     JSON序列化和反序列化工具，参考链接：https://www.liaoxuefeng.com/wiki/1252599548343744/1320418650619938
 * </p><br/>
 *
 * <ul>
 *     <li>JSON是轻量级的数据表示方式，常用于Web应用；</li>
 *     <li>Jackson可以实现JavaBean和JSON之间的转换；</li>
 *     <li>可以通过Module扩展Jackson能处理的数据类型；</li>
 *     <li>可以自定义JsonSerializer和JsonDeserializer来定制序列化和反序列化。</li>
 * </ul>
 *
 * <p>
 *     对于java.time包下的日期类型，比如LocalDateTime的使用：<br/>
 *     <blockquote><pre>
 *\    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 *\    @JsonSerialize(using = LocalDateTimeSerializer.class)
 *\    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
 *\    private LocalDateTime localDateTime;
 *     </pre></blockquote>
 * </p>
 *
 *
 */
public class JsonSerializationUtil {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDateTime，LocalDate，LocalTime
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);

        // 反序列化时忽略不存在的JavaBean属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            /*
            确定在找不到类型的访问器（并且没有注释指示要序列化）时发生的情况的功能。
            如果启用（默认），将引发异常，以指示这些类型为不可序列化类型；如果禁用，它们将序列化为空对象，即没有任何属性。
            请注意，此功能仅对那些没有任何可识别注释（如 @JsonSerialize）有效，有注释的类型不会导致抛出异常。
             */
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 设置默认日期序列化的格式信息，针对java.util.Date有效
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    }

    /**
     * 序列化对象成字符串
     * @param obj
     * @return
     */
    public static String serializeAsString(Object obj) {
        String str;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson serialize exception: " + e.getMessage(), e);
        }

        return str;
    }

    /**
     * 序列化对象成byte数组
     * @param obj
     * @return
     */
    public static byte[] serializeAsByteArray(Object obj) {
        byte[] byteArr;

        try {
            byteArr = mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson serialize exception: " + e.getMessage(), e);
        }

        return byteArr;
    }


    /**
     * 字符序列（字符串）反序列化为指定Java类型对象
     * @param content
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(CharSequence content, Class<T> clazz) {
        T obj = null;
        try {
            obj = mapper.readValue(content.toString(), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * byte数组反序列化为指定的Java类型对象
     * @param src
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] src, Class<T> clazz) {
        T obj = null;
        try {
            obj = mapper.readValue(src, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 字符序列（字符串）反序列化成Collection
     * @param content 字符序列
     * @param collectionClass Collection类型
     * @param elementClass Collection中元素类型
     * @return
     */
    public static <T> T deserializeCollection(CharSequence content, Class<? extends Collection> collectionClass, Class<?> elementClass) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);

        T obj;

        try {
            obj = mapper.readValue(content.toString(), javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson deserialize exception: " + e.getMessage(), e);
        }

        return obj;
    }

    /**
     * byte数组反序列化成Collection
     * @param src byte数组
     * @param collectionClass Collection类型
     * @param elementClass Collection中元素类型
     * @return
     */
    public static <T> T deserializeCollection(byte[] src, Class<? extends Collection> collectionClass, Class<?> elementClass) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);

        T obj = null;

        try {
            obj = mapper.readValue(src, javaType);
        } catch (IOException e) {
            throw new RuntimeException("jackson deserialize exception: " + e.getMessage(), e);
        }

        return obj;
    }

    /**
     * 字符序列（字符串）反序列化成Map
     * @param content 字符序列
     * @param mapClass Map类型
     * @param keyClass key类型
     * @param valueClass value类型
     * @return
     */
    public static <T> T deserializeMap(CharSequence content, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        JavaType type = mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        T obj = null;
        try {
            obj = mapper.readValue(content.toString(), type);
        } catch (IOException e) {
            throw new RuntimeException("jackson deserialize excpetion: " + e.getMessage(), e);
        }
        return obj;
    }

    /**
     * byte数组反序列化成Map
     * @param src byte数组
     * @param mapClass Map类型
     * @param keyClass key类型
     * @param valueClass value类型
     * @return
     */
    public static <T> T deserializeMap(byte[] src, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        JavaType type = mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        T obj = null;
        try {
            obj = mapper.readValue(src, type);
        } catch (IOException e) {
            throw new RuntimeException("jackson deserialize excpetion: " + e.getMessage(), e);
        }
        return obj;
    }
}
