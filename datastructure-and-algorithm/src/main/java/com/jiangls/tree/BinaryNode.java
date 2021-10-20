package com.jiangls.tree;

/**
 * 二叉树结点类型，二叉树链式存储结构中结点类型
 * @Author jiangls
 * @Date 2021/10/20
 */
public class BinaryNode<T> {
    private T data;

    private BinaryNode<T> lchild,rchild;

    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> lchild, BinaryNode<T> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLchild() {
        return lchild;
    }

    public void setLchild(BinaryNode<T> lchild) {
        this.lchild = lchild;
    }

    public BinaryNode<T> getRchild() {
        return rchild;
    }

    public void setRchild(BinaryNode<T> rchild) {
        this.rchild = rchild;
    }
}
