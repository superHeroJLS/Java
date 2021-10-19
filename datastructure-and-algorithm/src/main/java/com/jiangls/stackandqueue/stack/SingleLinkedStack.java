/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.stackandqueue.stack;


import com.jiangls.linearlist.linkedlist.SingleLinkedList;
/**
 * <p>栈，单链表存储实现，链式栈</p>
 * <p>链式栈是插入删除都在单链表表表头操作的特殊单链表，
 * 直接使用已经存在的单链表{@link SingleLinkedList}实现</p>
 * @Author jiangls
 * @Date 2021/10/15
 */
public final class SingleLinkedStack<T> implements Stack<T> {

    /**
     * 单链表
     */
    private SingleLinkedList<T> singleLinkedList;

    public SingleLinkedStack() {
        this.singleLinkedList = new SingleLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.singleLinkedList.isEmpty();
    }

    @Override
    public void push(T t) {
        // 单链表表头插入元素
        this.singleLinkedList.insert(0, t);
    }

    @Override
    public T pop() {
        return this.singleLinkedList.remove(0);
    }

    @Override
    public T peek() {
        return this.singleLinkedList.get(0);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.singleLinkedList.toString();
    }
}
