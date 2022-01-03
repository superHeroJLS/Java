package com.jiangls.tree;

/**
 * 顺序存储实现<b>完全二叉树</b>，使用数组存储<b>完全二叉树</b>所有节点，存储单元依次自上而下、自左而右存储<b>完全二叉树</b>上的节点元素<br>
 * <b>注意：顺序存储只适合存储完全二叉树（满二叉树是完全二叉树一个特例）</b>，顺序存储查找效率高，适用于频繁查找，很少插入、删除的场景
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class SequentialBinaryTreeGeneric<T extends BinaryTreeNode<E>, E> implements AbstractBinaryTree<T, E>{

    private T[] nodes;
    private int capacity = 8;

    public SequentialBinaryTreeGeneric() {
        nodes = (T[]) new BinaryTreeNode[this.capacity];
    }

    public SequentialBinaryTreeGeneric(int capacity) {
        this.capacity = capacity;
        nodes = (T[]) new BinaryTreeNode[this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int count() {
        int count = 0;
        for (T t : nodes) {
            if (t != null) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }

    @Override
    public int height() {
        if (this.count() == 0) {
            return 0;
        } else {
            return Double.valueOf(Math.log(this.count()) / Math.log(2)).intValue();
        }
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
    public T getParent(T node) {
        // 找到node在数组中的索引i
        int i = this.index(node);
        if (i == -1 || i == 0) {
            return null;
        } else {
            // 父节点的索引为 (i - 1) / 2
            return nodes[(i - 1 ) / 2];
        }
    }

    private int index(T node) {
        boolean flag = false;
        int i = 0;
        if (this.count() > 0) {
            for (; i < this.count(); i++) {
                if (nodes[i].equals(node)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            return i;
        } else {
            return -1;
        }
    }

    @Override
    public T getLeft(T node) {
        // 找到node在数组中的索引i
        // 左子节点的索引为 2 * i + 1
        int i = this.index(node);
        if (i == -1) {
            return null;
        } else {
            return nodes[i << 1 + 1];
        }
    }

    @Override
    public T getRight(T node) {
        // 找到node在数组中的索引i
        // 右子节点的索引为 2 * i + 1
        int i = this.index(node);
        if (i == -1) {
            return null;
        } else {
            return nodes[i << 1 + 2];
        }
    }

    @Override
    public T search(E key) {
        return null;
    }

    @Override
    public void insertRoot(E t) {

    }

    @Override
    public T insertChild(T p, E t, boolean lchild) {
        return null;
    }

    @Override
    public void removeChild(T p, boolean lchild) {

    }

    @Override
    public void removeAll() {

    }
}
