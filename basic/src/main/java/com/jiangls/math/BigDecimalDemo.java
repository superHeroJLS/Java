/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数</p>
 *
 * @Author jiangls
 * @Date 2021/10/15
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.456");
        System.out.println(bd.multiply(bd)); // 15241.383936

        // BigDecimal用scale()表示小数位数
        BigDecimal bd1 = new BigDecimal("123.45");
        BigDecimal bd2 = new BigDecimal("123.4500");
        BigDecimal bd3 = new BigDecimal("12345");
        System.out.println(bd1.scale());
        System.out.println(bd2.scale());
        System.out.println(bd3.scale());

        // 去掉末尾0
        BigDecimal bd4 = new BigDecimal("123.4500");
        BigDecimal bd5 = bd4.stripTrailingZeros();
        System.out.println(bd4.scale());
        System.out.println(bd5.scale());

        // 一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。
        BigDecimal bd6 = new BigDecimal("1234500");
        BigDecimal bd7 = bd6.stripTrailingZeros();
        System.out.println(bd6.scale());
        System.out.println(bd7.scale());

        // 对一个BigDecimal设置它的scale，如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断
        BigDecimal d1 = new BigDecimal("123.456789");
        BigDecimal d2 = d1.setScale(4, RoundingMode.UP); // 四舍五入，123.4568
        BigDecimal d3 = d1.setScale(4, RoundingMode.CEILING); // 直接截断，123.4567
        BigDecimal d4 = d1.setScale(4, RoundingMode.HALF_UP); // 直接截断，123.4567
        BigDecimal d5 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
        BigDecimal d6 = d1.setScale(4, RoundingMode.FLOOR); // 直接截断，123.4567
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);

        // 对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断
        d1 = new BigDecimal("123.456");
        d2 = new BigDecimal("23.456789");
        d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
        // d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽

        // 对BigDecimal做除法的同时求余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105

        // 调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，分别是商和余数，其中商总是整数，余数不会大于除数。
        // 我们可以利用这个方法判断两个BigDecimal是否是整数倍数
        n = new BigDecimal("12.75");
        m = new BigDecimal("0.15");
        dr = n.divideAndRemainder(m);
        if (dr[1].signum() == 0) {
            // n是m的整数倍
        }

        // 比较两个BigDecimal的值是否相等时，要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等
        //  总是使用compareTo()比较两个BigDecimal的值，不要使用equals()
        d1 = new BigDecimal("123.456");
        d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false,因为scale不同
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
        System.out.println(d1.compareTo(d2)); // 0


    }
}
