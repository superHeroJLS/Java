package com.jiangls.tree;

/**
 * 二叉树结点类型，二叉树链式存储结构中结点类型
 * @Author jiangls
 * @Date 2021/10/20
 */
public class BinaryTreeNode<E> {
    private E data;

    private BinaryTreeNode<E> lchild,rchild;

    public BinaryTreeNode() {
        this(null, null, null);
    }

    public BinaryTreeNode(E data) {
        this(data, null, null);
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> lchild, BinaryTreeNode<E> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryTreeNode<E> getLchild() {
        return lchild;
    }

    public void setLchild(BinaryTreeNode<E> lchild) {
        this.lchild = lchild;
    }

    public BinaryTreeNode<E> getRchild() {
        return rchild;
    }

    public void setRchild(BinaryTreeNode<E> rchild) {
        this.rchild = rchild;
    }
}
