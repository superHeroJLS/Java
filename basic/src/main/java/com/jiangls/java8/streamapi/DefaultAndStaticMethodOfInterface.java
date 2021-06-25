/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.java8.streamapi;

import java.util.function.Function;

/**
 * @Author jiangls
 * @Date 2021/6/25
 */
public class DefaultAndStaticMethodOfInterface {
    public static void main(String[] args) {
        Function.identity();
    }
}


/**
 * 继承Function
 *
 * @param <T>
 * @param <R>
 */
class SubFuction<T, R> implements Function<T, R> {
    @Override
    public R apply(T t) {
        return null;
    }

    void identity() {
        Function.identity();
    }
}
