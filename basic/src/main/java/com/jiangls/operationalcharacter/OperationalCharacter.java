/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.operationalcharacter;

import javax.sound.midi.Soundbank;

/**
 * @Author jiangls
 * @Date 2021/6/25
 */
public class OperationalCharacter {

    public static void main(String[] args) {
        // 小括号中的运算符优先级高于小括号外的运算符
        String s1 = "";
        String s2 = "s2";

        System.out.println((s1 = s2) == null);
        System.out.println((s1 = s2) == s2);
        System.out.println((s1 = s2) == s1);
        System.out.println((s1 = s2).equals("s2"));
    }


    /**
     * 运算符等于号，三元运算符的优先级高于 "=" 号
     */
    public static void operatorEqual() {
        String s1 = "";
        String s2 = "s2";

        s1 = s2 = true ? "true" : "false";
        System.out.println(s1);
        System.out.println(s2);
    }
}
