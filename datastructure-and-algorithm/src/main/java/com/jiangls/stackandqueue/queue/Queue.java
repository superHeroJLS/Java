/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.stackandqueue.queue;

/**
 * @Author jiangls
 * @Date 2021/10/15
 */
public interface Queue<T> {

    /**
     * 判空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     * 返回队头，不删除
     * @return
     */
    T peek();

    /**
     * 出队，返回队头
     * @return
     */
    T poll();
}
