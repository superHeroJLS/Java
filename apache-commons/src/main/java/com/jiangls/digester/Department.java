package com.jiangls.digester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiangls
 * @date 2022/3/6
 */
public class Department {
    private String name;
    private String code;
    // 扩展属性
    private Map<String, String> extension = new HashMap<>();
    private List<User> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void putExtension(String name, String value) {
        this.extension.put(name, value);
    }
}
