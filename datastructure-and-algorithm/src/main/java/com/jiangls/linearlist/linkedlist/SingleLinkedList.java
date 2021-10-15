package com.jiangls.linearlist.linkedlist;

import java.util.Objects;

/**
 * 线性表的单向链实现，简称为单链表
 * @Author jiangls
 * @Date 2021/9/7
 */
public class SingleLinkedList<T> {

    // 头结点，不保存数据
    public Node<T> head;

    /**
     * 构造空单链表
     */
    public SingleLinkedList() {
        this.head = new Node<>();
    }

    /**
     * 构造单链表
     * @param datas 数据
     */
    public SingleLinkedList(T[] datas) {
        this();

        // 尾插法构造单链表
        /*if (datas != null) {
            Node rear = this.head;
            for(int i = 0; i < datas.length; i++) {
                rear.next = new Node(datas[i], null);
                rear = rear.next;
            }
        }*/

        // 头插法构造单链表
        if (datas != null) {
            for(int i = 0; i < datas.length; i++) {
                this.head.next = new Node<>(datas[i], this.head.next);
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
        p.next = new Node<>(data, p.next);

        return p.next;
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

        // 第i-1个元素
        Node<T> prev = this.head;
        for (int j = 0; j < i - 1; j++) {
            prev = prev.next;
        }
        // 第i个元素
        Node<T> current = prev.next;
        if (current == null) {
            return null;
        }

        // 删除第i个元素
        prev.next = prev.next.next;

        return current.data;
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
        Node<T> q = ((SingleLinkedList<T>)o).head.next;

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
        // 指向后继节点
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }



}
