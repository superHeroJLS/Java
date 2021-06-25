/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.java8.streamapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author jiangls
 * @Date 2021/6/25
 */
public class FlatMapMethod {

    public static void main(String[] args) {
        List<Map<String, String>> mapList1 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        map1.put("k11", "v11");

        List<Map<String, String>> mapList2 = new ArrayList<>();
        Map<String, String> map2 = new HashMap<>();
        map2.put("k2", "v2");
        map2.put("k22", "v22");
        mapList2.add(map1);
        mapList2.add(map2);

        List<List<Map<String, String>>> list = new ArrayList<>();
        list.add(mapList1);
        list.add(mapList2);

        // 所谓flatMap()，是指把Stream的每个元素（这里是List）映射为Stream，然后合并成一个新的Stream
        Stream<Map<String, String>> mapStream = list.stream().flatMap(l ->l.stream());
        mapStream.forEach(System.out::println);
    }
}
