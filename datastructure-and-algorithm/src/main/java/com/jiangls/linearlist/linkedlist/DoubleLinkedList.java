package com.jiangls.linearlist.linkedlist;

import java.util.Objects;

/**
 * 线性表的双向链实现
 * @Author jiangls
 * @Date 2021/9/7
 */
public class DoubleLinkedList<T> {

    // 头结点，不保存数据
    public Node<T> head;

    /**
     * 构造空单链表
     */
    public DoubleLinkedList() {
        this.head = new Node<>();
    }

    /**
     * 尾插法构造单链表
     * @param datas 数据
     */
    public DoubleLinkedList(T[] datas) {
        this();
        if (datas != null) {
            Node rear = this.head;
            for(int i = 0; i < datas.length; i++) {
                rear.next = new Node(rear, datas[i], null);
                rear = rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * 返回链表中第i个元素，若i越界返回null
     * @param i
     * @return
     */
    public T get(int i) {
        if(i < 0) {
            return null;
        }

        // 遍历，寻找第i个节点
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }

        return p != null ? p.data : null;
    }

    public int size() {
        int i = 0;
        for(Node<T> p = this.head.next; p !=null; p = p.next) {
            i++;
        }
        return i;
    }

    /**
     * 设置第i个元素的值，若越界抛出异常异常
     */
    public void set(int i, T data) {
        if(i < 0 || i > size()) {
            throw new IndexOutOfBoundsException(i+"");
        }

        Node<T> p = this.head.next;
        for(int j = 0; j < i && p != null; j++){
            p = p.next;
        }

        p.data = data;
    }

    /**
     * 插入data作为第i个元素，返回插入节点。对序号i采取容错措施：i<0，插在链表最前面，i>n，插入在链表最后面
     * @param i
     * @param data
     * @return
     */
    public Node<T> insert(int i, T data) {
        // p指向头节点
        Node<T> p = this.head;
        for(int j = 0; p.next != null && j < i; j++) {
            p = p.next;
        }

        Node<T> q = new Node<>(p.prev, data, p);
        p.prev.next = q;
        p.prev = q;

        return q;
    }

    /**
     * 删除链表第i个元素，返回被删除的元素。若i越界返回null
     * @param i
     * @return
     */
    public T remove(int i) {
        if (i < 0 || i > size()) {
            return null;
        }

        // 第i个元素
        Node<T> p = this.head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }

        // 删除第i个元素
        p.prev.next = p.next;
        p.next.prev = p.prev;

        return p.data;
    }

    public Node<T> search(T data) {
        for(Node<T> p = this.head.next; p != null; p = p.next) {
            if (data.equals(p.data)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<T> p = this.head.next;
        Node<T> q = ((DoubleLinkedList<T>)o).head.next;

        while (p != null && q != null && p.data.equals(q.data)) {
            p = p.next;
            q = q.next;
        }

        return p == null && q == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    /**
     * 单链表节点类
     */
    public class Node<T> {
        // 数据
        public T data;
        // 指向前驱，后继节点
        public Node<T> prev, next;

        public Node(Node prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

}
