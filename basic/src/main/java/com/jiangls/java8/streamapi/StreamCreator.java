/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author jiangls
 * @Date 2021/6/25
 */
public class StreamCreator {
    public static void main(String[] args) {

        Stream<String> stream1 = streamOf("A","B","C");
        Stream<String> stream2 = streamOf(new String[]{"A","B","C"});
        stream1.forEach(System.out::print);
        stream2.forEach(System.out::print);


        // 基于数组或Collection
        Stream<String> stream3 = Arrays.stream(new String[] { "A", "B", "C" });
        Stream<String> stream4 = Arrays.asList("A", "B", "C").stream();
        stream3.forEach(System.out::println);
        stream4.forEach(System.out::println);


        // 基于Supplier
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);


        /*
        Files类的lines()方法可以把一个文件变成一个Stream，每个元素代表文件的一行内容
        try (Stream<String> lines = Files.lines(Paths.get("/path/to/file.txt"))) {}
        */


        // 正则表达式的Pattern对象有一个splitAsStream()方法，可以直接把一个长字符串分割成Stream序列而不是数组：
        Pattern pattern = Pattern.compile("\\s+");
        Stream<String> s = pattern.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);


    }

    // 传入数组或可变参数创建Stream
    public static <T> Stream<T> streamOf(T... values) {
        return Stream.of(values);
    }
}

class NatualSupplier implements Supplier<Integer> {
    AtomicInteger ai = new AtomicInteger(0);

    @Override
    public Integer get() {
        return ai.getAndIncrement();
    }
}
