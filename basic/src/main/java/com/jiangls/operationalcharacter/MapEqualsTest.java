/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.operationalcharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiangls
 * @Date 2021/9/2
 */
public class MapEqualsTest {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put("k", "v");
        map2.put("k", "v");

        System.out.println("map1 == map2 " + (map1 == map2));
        System.out.println("map1 equals map2 " + (map1.equals(map2)));
    }
}
