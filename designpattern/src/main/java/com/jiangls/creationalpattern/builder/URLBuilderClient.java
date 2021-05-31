package com.jiangls.creationalpattern.builder;

import java.util.HashMap;
import java.util.Map;

public class URLBuilderClient {
    public static void main(String[] args) {
        Map<String, String> query = new HashMap<>();
        query.put("a", "123");
        query.put("q", "K&R");
        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.liaoxuefeng.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(query) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }
}
