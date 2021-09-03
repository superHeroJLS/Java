package com.jiangls.linearlist.sequentiallist;

import java.util.Arrays;

/**
 * 线性表的顺序存储实现，可简称为顺序表
 *
 * @Author jiangls
 * @Date 2021/9/3
 */
public class SequentialList<T> {
    protected Object[] element;
    protected int len;

    /**
     * 构造容量为length的空表
     *
     * @param length
     */
    public SequentialList(int length) {
        element = new Object[length];
        this.len = 0;
    }

    /**
     * 默认构造容量为64的空表
     */
    public SequentialList() {
        this(64);
    }

    public SequentialList(T[] values) {
        this.element = values;
        this.len = values.length;
    }

    /**
     * 判断是否为空表，空表返回true，否则返回false
     * @return
     */
    public boolean isEmpty() {
        return this.len == 0;
    }

    /**
     * 返回表中元素个数
     *
     * @return
     */
    public int size() {
        return this.len;
    }

    public T get(int i) {
        if (i > 0 && i < this.len) {
            return (T) element[i];
        }
        return null;
    }

    public void set(int i, T ele) {
        if (i > 0 && i < this.len) {
            this.element[i] = ele;
        } else {
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    @Override
    public String toString() {
        return "SequentialList{" +
                "element=" + Arrays.toString(element) +
                '}';
    }


}
