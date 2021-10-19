/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.stackandqueue.queue;

/**
 * <p>队列的顺序存储结构称为顺序队列。和顺序表一样，顺序队列用一个数组空间存放当前队列元素。</p>
 * <p>使用数组存在假溢出现象。</p>
 * <p>解决数组假溢出方案：循环队列Circual Queue，将顺序队列设计成在逻辑上首位相接的循环机构，则可循环使用顺序队列的连续存储单元。</p>
 *
 * <p>参考链接：
 *     <a href=https://www.icourse163.org/learn/ZZU-1207193805?tid=1461941470#/learn/content?type=detail&id=1238766411&cid=1259545391>
 *         https://www.icourse163.org/learn/ZZU-1207193805?tid=1461941470#/learn/content?type=detail&id=1238766411&cid=1259545391
 *     </a>
 * </p>
 * @Author jiangls
 * @Date 2021/10/15
 */
public class SequentialQueue<T> implements Queue<T> {

    private Object[] elements;
    // 队头和队尾
    private int front, rear;

    // 队列默认长度
    private  static final int initCapacity = 64;

    public SequentialQueue() {
        this(initCapacity);
    }

    public SequentialQueue(int length) {
        elements = new Object[length];

        // 队头和队尾初始时指向数组下标为0的位置，此时0位置无元素
        this.front = this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        /**
         * 1 队列初始化时，front和rear的值相等
         * 2 当队列中所有元素都从队头出队后，front和rear的值相等
         */
        return this.front == this.rear;
    }

    @Override
    public boolean add(T t) {
        if(t == null) {
            throw new NullPointerException("t == null");
        }

        // 队列满，扩充数组容量
        if (this.front == (this.rear + 1) % this.elements.length) {
            Object[] temp = this.elements;

            // 容量扩充为2倍
            this.elements = new Object[this.elements.length << 1];

            // 复制旧数组至新数组中
            int j = 0;
            for (int i = this.front; i != this.rear; i = (i + 1) % this.elements.length) {
                this.elements[j++] = temp[i];
            }
            this.front = 0;
            this.rear = j;

            // 首先新元素添加至数组中
            this.elements[this.rear] = t;
            // 然后rear下标值加1，此时rear下标值的位置没有存放任何元素的
            this.rear = (this.rear + 1) % this.elements.length;
        }

        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : (T) this.elements[this.front];
    }

    @Override
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }

        // 首先拿到队头元素
        T t = (T) this.elements[this.front];
        // 然后front加1
        this.front = (this.front + 1) % this.elements.length;

        return t;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(this.getClass().getName() + "(");
        for (int i = this.front; i != this.rear; i = (this.front + 1) % this.elements.length) {
            sb.append(this.elements[i].toString() + ",");
        }

        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }
}
