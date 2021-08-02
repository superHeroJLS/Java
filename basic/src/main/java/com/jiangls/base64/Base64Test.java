/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.base64;

import java.util.Base64;

/**
 * @Author jiangls
 * @Date 2021/8/2
 */
public class Base64Test {
    public static void main(String[] args) {
        String str = "test:123456";
        String strAfterBase64 = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(strAfterBase64);
    }
}
