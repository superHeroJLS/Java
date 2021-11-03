package com.jiangls.xml;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jiangls.xml.javabean.Book;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>XML文档解析成一个JavaBean</p>
 * 一个名叫Jackson的开源的第三方库可以轻松做到XML到JavaBean的转换。我们要使用Jackson，先添加Maven的依赖：
 * <ol>
 *     <li>com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.10.1</li>
 * </ol>
 *
 * <p>如果要解析的数据格式不是Jackson内置的标准格式，那么需要编写一点额外的扩展来告诉Jackson如何自定义解析。
 * 这里我们不做深入讨论，参考Jackson的官方文档：https://github.com/FasterXML/jackson</p>
 */
public class XmlToJavaBeanWithJackson {
    public static void main(String[] args) throws IOException {

        InputStream input = XmlToJavaBeanWithJackson.class.getResourceAsStream("/book.xml");

        /**
         * XmlMapper就是我们需要创建的核心对象。
         *
         * 如果要解析的数据格式不是Jackson内置的标准格式，那么需要编写一点额外的扩展来告诉Jackson如何自定义解析。
         * 这里我们不做深入讨论，可以参考Jackson的官方文档。
         */
        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        XmlMapper xmlMapper = new XmlMapper(jacksonXmlModule);

        Book book = xmlMapper.readValue(input, Book.class);
        System.out.println(book.toString());
    }
}
