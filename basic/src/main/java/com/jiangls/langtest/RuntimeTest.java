/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.langtest;

import java.io.IOException;

/**
 * @Author jiangls
 * @Date 2021/8/5
 */
public class RuntimeTest {
    public static void main(String[] args) {
        memoryInfo();
    }

    /**
     * 获取内存信息
     */
    public static void memoryInfo() {
        // JVM总内存
        System.out.println("Total memory in MB: " + (Runtime.getRuntime().totalMemory() >> 10 >> 10));

        // JVM可从操作系统中获取使用的最大内存
        System.out.println("Max memory in MB: " + (Runtime.getRuntime().maxMemory() >> 10 >> 10));

        // JVM空闲内存
        System.out.println("Free memory in MB: " + (Runtime.getRuntime().freeMemory() >> 10 >> 10));
    }

}
