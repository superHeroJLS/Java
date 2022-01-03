package com.jiangls.tree;

/**
 * 顺序存储实现<b>完全二叉树</b>，使用数组存储<b>完全二叉树</b>所有节点，存储单元依次自上而下、自左而右存储<b>完全二叉树</b>上的节点元素<br>
 * <b>注意：顺序存储只适合存储完全二叉树（满二叉树是完全二叉树一个特例）</b>，顺序存储查找效率高，适用于频繁查找，很少插入、删除的场景
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class SequentialBinaryTree implements AbstractBinaryTree<BinaryTreeNode<Object>, Object>{

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public BinaryTreeNode<Object> getParent(BinaryTreeNode<Object> node) {
        return null;
    }

    @Override
    public BinaryTreeNode<Object> getLeft(BinaryTreeNode<Object> node) {
        return null;
    }

    @Override
    public BinaryTreeNode<Object> getRight(BinaryTreeNode<Object> node) {
        return null;
    }

    @Override
    public BinaryTreeNode<Object> search(Object key) {
        return null;
    }

    @Override
    public void insertRoot(Object t) {

    }

    @Override
    public BinaryTreeNode<Object> insertChild(BinaryTreeNode<Object> p, Object t, boolean lchild) {
        return null;
    }

    @Override
    public void removeChild(BinaryTreeNode<Object> p, boolean lchild) {

    }

    @Override
    public void removeAll() {

    }
}
