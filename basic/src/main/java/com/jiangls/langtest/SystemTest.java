/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.langtest;

import java.util.Map;
import java.util.Properties;

/**
 * @Author jiangls
 * @Date 2021/8/5
 */
public class SystemTest {

    public static void main(String[] args) {
        getEnv();
        getProperties();
    }

    /**
     * 获取操作系统环境变量
     */
    public static void getEnv() {
        System.err.println("Open system environment shown as:");
        Map<String,String> osEnv = System.getenv();
        osEnv.forEach((key, value) -> System.out.println("osEnv: " + key + ":" + value));
    }

    /**
     * 获取Java应用的属性
     */
    public static void getProperties() {
        System.err.println("Java application properties shown as: ");
        Properties appProperties = System.getProperties();
        appProperties.forEach((key, value) -> System.out.println("appProperties: " + key + ": " + value));
    }
}
