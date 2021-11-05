package com.jiangls.json.javabean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.jiangls.json.jsondeserializer.IsbnDeserializer;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Book {
    public long id;
    public String name;
    public Map<String, String> author;
    public String isbn;
    public List<String> tags;
    /**
     * Jackson反序列化特定Java对象，比如LocalDate类型，只需要引入标准的JSR 310关于JavaTime的数据格式定义至Maven
     * com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.0
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate pubDate;

    @JsonDeserialize(using = IsbnDeserializer.class)
    public BigInteger isbn2;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAuthor() {
        return author;
    }

    public void setAuthor(Map<String, String> author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public BigInteger getIsbn2() {
        return isbn2;
    }

    public void setIsbn2(BigInteger isbn2) {
        this.isbn2 = isbn2;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", pubDate=" + pubDate +
                ", isbn2=" + isbn2 +
                '}';
    }
}
