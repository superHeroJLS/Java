/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.keyfinal;

import java.util.HashSet;
import java.util.Set;

/**
 * 关键字final测试
 * @Author jiangls
 * @Date 2021/6/24
 *
 * 文章参考：https://www.cnblogs.com/dolphin0520/p/3736238.html
 */
public class KeyFinal {

    private final int i = 100;
    private final Set<String> stringSet = new HashSet<>();


    public static void main(String[] args) {
        KeyFinal kf = new KeyFinal();
        // final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改
        //kf.i = 99;
        System.out.println("i: " + kf.i);

        // final变量，如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象
        kf.stringSet.add("123");
        kf.stringSet.add("abc");
        System.out.println("stringSet: " + kf.stringSet);
    }


}

