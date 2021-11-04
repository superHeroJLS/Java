package com.jiangls.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jiangls.json.javabean.Book;
import com.jiangls.json.jsondeserializer.IsbnDeserializer;

import java.io.IOException;
import java.io.InputStream;

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
 *
 */
public class JsonSerializationUtil {

    public static void main(String[] args) throws IOException {
        demo();
        demoOfDataTypeJsr310();
        demoOfIsbnDeserializer();
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
