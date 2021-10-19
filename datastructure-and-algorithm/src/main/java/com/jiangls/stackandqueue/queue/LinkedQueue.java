/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.stackandqueue.queue;

/**
 * <p>队列是特殊的线性表，只考虑对线性表2端操作的情况，且只能在一端插入另一端删除；
 * 理解时可以把队列的入、出队运算当作只能在线性表2端进行插入删除的特例</p>
 * <p>队列的链式存储结构简称链队列，<b>限制仅在表头删除和表尾插入的链表，链队列由头指针和尾指针唯一确定</b></p>
 * <p>链队列各种运算比链式存储的普通线性表运算实现时要方便很多，主要原因是队列的各种运算只能在队列的2端操作</p>
 *
 * @Author jiangls
 * @Date 2021/10/15
 */
public final class LinkedQueue<T> implements Queue<T> {

    private Node<T> front, rear;

    public LinkedQueue() {
        this(null, null);
    }

    public LinkedQueue(Node<T> front, Node<T> rear) {
        this.front = front;
        this.rear = rear;
    }

    public LinkedQueue(T[] ts) {
        this(null, null);
        if (ts.length > 0) {
            // 队头
            this.front = new Node<>(ts[0], null);
            // 队尾
            this.rear = this.front;
            for (int i = 1; i < ts.length; i++) {
                Node<T> node = new Node<>(ts[i], null);
                // 队尾插入
                this.rear.next = node;
                this.rear = node;
            }
        }

    }


    @Override
    public boolean isEmpty() {
        return this.front == null && this.rear == null;
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException("t == null");
        }

        Node<T> node = new Node<>(t, null);
        if (this.front == null) {
            // 空队插入
            this.front = node;
        } else {
            // 队尾插入
            this.rear.next = node;
        }
        this.rear = node;

        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : this.front.data;
    }

    @Override
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }

        // 取队头元素
        Node<T> node = this.front;
        // 删除队头元素
        this.front = this.front.next;

        return node != null ? node.data : null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(this.getClass().getName() + "(");
        for (Node<T> p = this.front; p != null; p = p.next) {
            sb.append(p.data.toString() + ",");
        }

        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            this(null, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
