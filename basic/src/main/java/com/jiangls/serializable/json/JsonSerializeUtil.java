package com.jiangls.serializable.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

/**
 * Json 序列化, 反序列化工具
 */
public class JsonSerializeUtil {

    private static ObjectMapper objMapper;

    static {
        objMapper = new ObjectMapper();

        objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objMapper.registerModule(new JodaModule());

//        Hibernate5Module h5module = new Hibernate5Module();
//        h5module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
//        objMapper.registerModule(h5module);

//        SimpleModule simpleModule = new SimpleModule();
//
//        // 设置java.sql.Date类型字段的日期格式与java.util.Date相同
//        simpleModule.addSerializer(java.sql.Date.class, new SqlDate2UtilDateSerializer());
//        objMapper.registerModule(simpleModule);

        // 设置日期序列化的格式信息
        objMapper.setDateFormat(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

//        //设置单位的格式化信息
//        simpleModule.addSerializer(Unit.class, new UnitJsonSerializer());
//
//        //设置单位数量值的格式化信息
//        simpleModule.addSerializer(Amount.class, new AmountJsonSerializer());


        // 忽略反序列化时的未知字段
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将java对象序列化为JSON字符串
     *
     * @param object
     * @return
     */
    public static String serializeAsString(Object object) {
        String str = "";
        try {
            str = objMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return str;
    }

    /**
     * 将java对象序列化为美化的JSON字符串，适合打印输出
     *
     * @param object
     * @return
     */
    public static String serializeAsPrettyString(Object object) {
        String str = "";
        try {
            str = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return str;
    }

    /**
     * 将java对象序列化为JSON字节数组
     *
     * @param object
     * @return
     */
    public static byte[] serializeAsBytes(Object object) {
        byte[] bs = {};
        try {
            bs = objMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return bs;
    }

    /**
     * 将java对象序列化并输出到指定的输出流
     *
     * @param out
     * @param object
     */
    public static void serializeToOutputStream(OutputStream out, Object object) {
        try {
            objMapper.writeValue(out, object);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
    }

    /**
     * 将字符序列 (字符串) 反序列化为指定类型的Java对象
     *
     * @param content
     * @param clazz
     */
    public static <T> T deserialize(CharSequence content, Class<T> clazz) {
        T obj = null;
        try {
            obj = objMapper.readValue(content.toString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    /**
     * 将byte数组反序列化为指定类型的Java对象
     *
     * @param bs
     * @param clazz
     */
    public static <T> T deserialize(byte[] bs, Class<T> clazz) {
        T obj = null;
        try {
            obj = objMapper.readValue(bs, clazz);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    /**
     * 从InputStream中读取, 并反序列化为指定类型的Java对象
     *
     * @param in
     * @param clazz
     */
    public static <T> T deserialize(InputStream in, Class<T> clazz) {
        T obj = null;
        try {
            obj = objMapper.readValue(in, clazz);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    /**
     * 将字符序列反序列化成指定的Collection <br/>
     * <p>
     * <p>
     * 例如: 若对象类型为 List&lt;CustomModel&gt;, 则调用方式为: <br/>
     * deserializeCollection(content, List.class, CustomModel.class)
     * </p>
     *
     * @param content
     *            字符序列
     * @param collectionClass
     *            Collection 子类的class
     * @param elementClass
     *            Collection 泛型参数类的class
     */
    public static <T> T deserializeCollection(CharSequence content,
                                              @SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<?> elementClass) {
        JavaType type = objMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
        T obj = null;
        try {
            obj = objMapper.readValue(content.toString(), type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    /**
     * 将byte数组反序列化成指定的Collection <br/>
     * <p>
     * <p>
     * 例如: 若对象类型为 List&lt;CustomModel&gt;, 则调用方式为: <br/>
     * deserializeCollection(content, List.class, CustomModel.class)
     * </p>
     *
     * @param bs
     *            byte 数组
     * @param collectionClass
     *            Collection 子类的class
     * @param elementClass
     *            Collection 泛型参数类的class
     */
    public static <T> T deserializeCollection(byte[] bs,
                                              @SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<?> elementClass) {
        JavaType type = objMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
        T obj = null;
        try {
            obj = objMapper.readValue(bs, type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    public static <T> T deserializeCollection(InputStream in,
                                              @SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<?> elementClass) {
        JavaType type = objMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
        T obj = null;
        try {
            obj = objMapper.readValue(in, type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    public static <T> T deserializeMap(CharSequence content,
                                       @SuppressWarnings("rawtypes") Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        JavaType type = objMapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        T obj = null;
        try {
            obj = objMapper.readValue(content.toString(), type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    public static <T> T deserializeMap(byte[] bs, @SuppressWarnings("rawtypes") Class<? extends Map> mapClass,
                                       Class<?> keyClass, Class<?> valueClass) {
        JavaType type = objMapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        T obj = null;
        try {
            obj = objMapper.readValue(bs, type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }

    public static <T> T deserializeMap(InputStream in, @SuppressWarnings("rawtypes") Class<? extends Map> mapClass,
                                       Class<?> keyClass, Class<?> valueClass) {
        JavaType type = objMapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        T obj = null;
        try {
            obj = objMapper.readValue(in, type);
        } catch (IOException e) {
            throw new RuntimeException("jackson serialize/unserialize excpetion: \n" + e.getMessage());
        }
        return obj;
    }
}
