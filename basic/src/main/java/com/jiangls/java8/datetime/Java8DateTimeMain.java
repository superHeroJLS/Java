package com.jiangls.java8.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * java8 日期类型参考：https://www.liaoxuefeng.com/wiki/1252599548343744/1303871087444002
 */
public class Java8DateTimeMain {

    public static void main(String[] args) {
        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        System.out.println(dtf.format(LocalDateTime.now())); // 2021-11-05 11:46:53

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019-11-30 15:16:17", dtf);
        System.out.println(dt2); // 2019-11-30T15:16:17
    }
}
