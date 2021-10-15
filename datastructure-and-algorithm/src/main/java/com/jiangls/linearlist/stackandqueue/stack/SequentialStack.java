/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.linearlist.stackandqueue.stack;

import com.jiangls.linearlist.sequentiallist.SequentialList;

/**
 * <p>栈，顺序存储实现，顺序栈。</p>
 * <p>顺序栈是运算受限的线性表，因此线性表的存储结构对栈也适应，
 * 直接使用已经存在的顺序表{@link SequentialList}实现</p>
 *
 * @Author jiangls
 * @Date 2021/10/15
 */
public final class SequentialStack<T> implements Stack<T> {

    /**
     * 顺序表
     */
    private SequentialList<T> sequentialList;

    @Override
    public boolean isEmpty() {
        return this.sequentialList.isEmpty();
    }

    public SequentialStack() {
       this(64);
    }

    public SequentialStack(int capacity) {
        this.sequentialList = new SequentialList<>(capacity);
    }

    @Override
    public void push(T t) {
        this.sequentialList.insert(this.sequentialList.getLen(), t);
    }

    @Override
    public T pop() {
        return this.sequentialList.remove(this.sequentialList.getLen());
    }

    @Override
    public T peek() {
        return this.sequentialList.get(this.sequentialList.getLen());
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.sequentialList.toString();
    }
}
