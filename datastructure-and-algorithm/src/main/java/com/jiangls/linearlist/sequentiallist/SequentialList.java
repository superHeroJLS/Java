package com.jiangls.linearlist.sequentiallist;

import java.util.Arrays;

/**
 * 线性表的顺序存储实现，可简称为顺序表
 *
 * @Author jiangls
 * @Date 2021/9/3
 */
public class SequentialList<T> {
    protected Object[] elements;
    protected int len;

    /**
     * 构造容量为length的空表
     *
     * @param length
     */
    public SequentialList(int length) {
        elements = new Object[length];
        this.len = 0;
    }

    /**
     * 默认构造容量为64的空表
     */
    public SequentialList() {
        this(64);
    }

    public SequentialList(T[] values) {
        this.elements = values;
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
            return (T) elements[i];
        }
        return null;
    }

    public void set(int i, T ele) {
        if (i > 0 && i < this.len) {
            this.elements[i] = ele;
        } else {
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    @Override
    public String toString() {
        return "SequentialList{" +
                "element=" + Arrays.toString(elements) +
                '}';
    }

    /**
     * 插入ele作为第i个元素，返回ele元素的下标
     *
     * @param i
     * @param ele
     * @return ele元素下标
     */
    public int insert(int i, T ele) {
        // 下标越界
        if(i < 0) {
            throw new IndexOutOfBoundsException(i+"");
        }
        // i大于数组中元素个数，ele插入在元素最后
        if(i > this.len) {
            i = this.len;
        }

        Object[] sourceElements = this.elements;
        // 数组已满，数组扩容
        if (this.len == elements.length) {
            this.elements = new Object[elements.length * 2];
            // 复制i-1个元素到新数组中
            for (int j = 0; j < i; j++) {
                this.elements[j] = sourceElements[j];
            }
        }

        // 从i开始至表尾的元素向后移动一位
        for (int j = i; j < this.len; j++) {
            this.elements[j+1] = sourceElements[j];
        }

        this.elements[i] = ele;
        this.len++;
        return i;
    }

    /**
     * 删除下标为i的元素，返回被删除的元素
     * @param i
     * @return
     */
    public T remove(int i) {
        T eleRemoved = null;
        // 下标越界
        if (i < 0 || i > elements.length) {
            throw new IndexOutOfBoundsException(i+"");
        }

        // 下标超过数组中元素个数
        if (i > this.len-1) {
            return eleRemoved;
        }

        eleRemoved = (T) this.elements[i];
        // 从下标i+1开始，元素向前移动一位
        for (int j = i; j < this.len - 1; j++) {
            this.elements[j] = this.elements[j+1];
        }

        // 设置数组中最后一个元素为null，释放原引用实例
        this.elements[this.len-1] = null;
        this.len--;

        return eleRemoved;
    }

    public int getLen() {
        return this.len;
    }


}
