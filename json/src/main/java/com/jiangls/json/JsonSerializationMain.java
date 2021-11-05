package com.jiangls.json;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.DateType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jiangls.json.javabean.Book;
import com.jiangls.json.javabean.Java8DateTimeType;
import com.jiangls.json.javabean.VariousDateType;
import com.jiangls.json.jsondeserializer.IsbnDeserializer;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *     JSON序列化和反序列化测试类，参考链接：https://www.liaoxuefeng.com/wiki/1252599548343744/1320418650619938
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
 *     java.time.LocalDateTime参考：https://www.liaoxuefeng.com/wiki/1252599548343744/1303871087444002
 * </p>
 *
 *
 */
public class JsonSerializationMain {
    public static void main(String[] args) throws IOException {
//        demo();
//        demoOfDataTypeJsr310();
//        demoOfIsbnDeserializer();

//        serializeJava8DateTime();

        serializeVariousDateType();

    }

    /**
     * jackson序列化和反序列化java.time.LocalDateTiem<br/><br/>
     *
     * maven依赖添加jackson-datatype-jsr310<br/><br/>
     *
     * ObjectMapper注册新Module：JavaTimeModule<br/><br/>
     *
     * LocalDateTimeSerializer序列化默认格式：2021-11-05T12:47:47.936<br/><br/>
     *
     * LocalDateTimeDeserializer反序列化默认格式：2021-11-05T12:47:47.936
     *
     * @throws JsonProcessingException
     */
    public static void serializeJava8DateTime() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDateTime，LocalDate，LocalTime
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);
        // setDateFormat对java.time.LocalDateTime不起作用
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // 序列化
        Java8DateTimeType java8DateTimeType = new Java8DateTimeType();
        java8DateTimeType.setDatetime(LocalDateTime.now());
        System.out.println(mapper.writeValueAsString(java8DateTimeType)); // {"datetime":"2021-11-05 12:45:24"}

        // 反序列化
        String json = "{\"datetime\":\"2021-11-05 11:52:13\"}";
        Java8DateTimeType java8DateTimeType2 = mapper.readValue(json, Java8DateTimeType.class);
        System.out.println(java8DateTimeType2.toString()); // Java8DateTimeType{date=2021-11-05T11:52:13}
    }

    /**
     * 序列化和反序列化各种日期类型：
     * <ol>
     *     <li>java.util.Date</li>
     *     <li>java.time.LocalDateTime</li>
     *     <li>java.util.LocalDate</li>
     *     <li>java.util.LocalTime</li>
     * </ol>
     */
    public static void serializeVariousDateType() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDateTime，LocalDate，LocalTim
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
        // 设置日期序列化的格式信息，这个设置对java.time.LocalDateTime不起作用
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // 读取json文件
        InputStream input = JsonSerializationUtil.class.getResourceAsStream("/datetype.json");

        // 反序列化
        VariousDateType dateType = mapper.readValue(input, VariousDateType.class);
        System.out.println("deserialize result: ");
        System.out.println(dateType.getDate().toLocaleString());
        System.out.println(dateType.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(dateType.getLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(dateType.getLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // 序列化
        String json = mapper.writeValueAsString(dateType);
        System.err.println("----------------------------------------");
        System.out.println("serialize result: ");
        System.out.println(json);

        // 序列化属性全为null的对象
        String json1 = mapper.writeValueAsString(new VariousDateType());
        System.err.println("----------------------------------------");
        System.out.println("serialize result: ");
        System.out.println(json1);
    }

    /**
     * 将json字符串反序列化成java对象，将java对象序列化成json字符串
     */
    public static void demo() throws IOException {
        InputStream input = JsonSerializationUtil.class.getResourceAsStream("/book.json");

        ObjectMapper mapper = new ObjectMapper();
        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDate
        mapper.registerModule(new JavaTimeModule());
        // 反序列化时忽略不存在的JavaBean属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 序列化时，json字符串有缩进，便于阅读
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);


        // 反序列化
        Book book = mapper.readValue(input, Book.class);
        System.out.println("反序列化JavaBean结果：");
        System.out.println(book.toString());
        System.out.println();

        // 序列化
        System.out.println("序列化Json字符串结果，Json字符串有缩进：");
        String jsonStr = mapper.writeValueAsString(book);
        System.out.println(jsonStr);
        System.out.println("----------------------------------------");
    }


    /**
     * Jackson反序列化特定Java对象，比如LocalDate类型，只需要引入标准的JSR 310关于JavaTime的数据格式定义至Maven<br/>
     * com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.0<br/>
     *
     * <b>注意在创建ObjectMapper时，注册一个新的JavaTimeModule</b>
     * @throws IOException
     */
    public static void demoOfDataTypeJsr310() throws IOException {
        InputStream input = JsonSerializationUtil.class.getResourceAsStream("/book.json");

        ObjectMapper mapper = new ObjectMapper();
        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDate
        mapper.registerModule(new JavaTimeModule());
        // 反序列化时忽略不存在的JavaBean属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 反序列化
        Book book = mapper.readValue(input, Book.class);
        System.out.println("反序列化JavaBean结果：");
        System.out.println(book.toString());
        System.out.println();

        // 序列化
        System.out.println("序列化Json字符串结果：");
        String jsonStr = mapper.writeValueAsString(book);
        System.out.println(jsonStr);
        System.out.println("--------------------------------------------------");
    }

    /**
     * 有些时候，内置的解析规则和扩展的解析规则如果都不满足我们的需求，<b>还可以自定义解析。</b>
     * 举个例子，假设Book类的isbn是一个BigInteger
     * <blockquote><pre>
     *     public class Book {
     *          public String name;
     *          public BigInteger isbn;
     *      }
     * </pre></blockquote>
     *
     * 但JSON数据并不是标准的整形格式：
     *<blocckquote><pre>
     *     {
     *          "name": "Java核心技术",
     *          "isbn2": "978-7-111-54742-6"
     *      }
     *</pre></blocckquote>
     *
     * 直接解析，肯定报错。这时，我们需要<b>自定义一个{@link IsbnDeserializer}，用于解析含有非数字的字符串</b><br/>
     *
     * 最后，在{@link Book}类isbn2上使用注解：<b>@JsonDeserialize(using = IsbnDeserializer.class)</b>
     *
     * @throws IOException
     */
    public static void demoOfIsbnDeserializer() throws IOException {
        InputStream input = JsonSerializationUtil.class.getResourceAsStream("/book.json");

        ObjectMapper mapper = new ObjectMapper();
        // 添加JavaTimeModule模块，使得Jackson支持JSR 310中的Java数据类型，比如LocalDate
        mapper.registerModule(new JavaTimeModule());
        // 反序列化时忽略不存在的JavaBean属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 反序列化
        Book book = mapper.readValue(input, Book.class);
        System.out.println("反序列化JavaBean结果：");
        System.out.println(book.toString());
        System.out.println();

        // 序列化
        System.out.println("序列化Json字符串结果：");
        String jsonStr = mapper.writeValueAsString(book);
        System.out.println(jsonStr);
    }
}
