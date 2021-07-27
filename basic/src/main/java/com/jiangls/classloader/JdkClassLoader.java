/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.classloader;

/**
 * @Author jiangls
 * @Date 2021/7/27
 */
public class JdkClassLoader {
    public static void main(String[] args) {

        // JdkClassLocader类加载器为Launcher$AppClassLoader
        System.out.println(JdkClassLoader.class.getClassLoader());

        // Launcher$AppClassLoader类加载器为BootstrapClassLoader，因为BootstrapClassLoader不是Java代码实现的，所以打印出来的是null
        System.out.println(JdkClassLoader.class.getClassLoader().getClass().getClassLoader());

        // Launcher$AppClassLoader的父加载器是Launcher$ExtClassLoader
        System.out.println(JdkClassLoader.class.getClassLoader().getParent());

        // Launcher$ExtClassLoader类加载器为BootstrapClassLoader，因为BootstrapClassLoader不是Java代码实现的，所以打印出来的是null
        System.out.println(JdkClassLoader.class.getClassLoader().getParent().getClass().getClassLoader());

    }
}
