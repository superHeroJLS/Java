/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.linearlist.stackandqueue.stack;

/**
 * @Author jiangls
 * @Date 2021/10/15
 */
public interface Stack<T> {

    boolean isEmpty();

    /**
     * 入栈
     * @param t
     */
    void push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 返回栈顶元素，栈顶元素不出栈
     * @return
     */
    T peek();
}
