/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jiangls
 * @Date 2021/9/8
 */
public class HashSetDemo {

    public static void main(String[] args) {
        elementCompare();
    }


    /**
     * <p>HashSet中元素不可重复，元素为引用对象，元素之间是如何比较是否相等的</p>
     *
     * <p>元素之间比较相等通过2个方法：
     *     <li>hashCode()</li>
     *     <li>equals()</li>
     * </p>
     */
    public static void elementCompare(){
        User u1 = new User("1", "jiangls");
        User u2 = new User("1", "jls");

        System.out.println("u1 == u2: " + (u1 == u2));
        System.out.println("u1.hashCode() == u2.hashCode(): " + (u1.hashCode() == u2.hashCode()));
        System.out.println("u1.equals(u2): " + (u1.equals(u2)));

        Set<User> userSet = new HashSet<>();
        userSet.add(u1);
        userSet.add(u2);

        System.out.println("set size: " +userSet.size());
    }
}
