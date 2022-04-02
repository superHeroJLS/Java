package com.jiangls.digester;

/**
 * @author Jiangls
 * @date 2022/3/6
 */
public class User {
    private String name;
    private String code;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
