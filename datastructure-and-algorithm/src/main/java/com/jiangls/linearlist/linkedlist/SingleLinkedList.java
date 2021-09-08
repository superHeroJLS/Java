package com.jiangls.linearlist.linkedlist;

/**
 * 线性表的单向链实现，简称为单链表
 * @Author jiangls
 * @Date 2021/9/7
 */
public class SingleLinkedList<T> {

    // 头结点，不保存数据
    protected Node<T> head;

    /**
     * 构造空单链表
     */
    public SingleLinkedList() {
        this.head = new Node<>();
    }

    /**
     * 尾插法构造单链表
     * @param datas 数据
     */
    public SingleLinkedList(T[] datas) {
        this();
        if (datas != null) {
            Node rear = this.head;
            for(int i = 0; i < datas.length; i++) {
                rear.next = new Node(datas[i], null);
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
     * 设置第i个节点，若越界抛出异常异常
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
