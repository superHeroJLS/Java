package com.jiangls.tree;

/**
 * 二叉树抽象类
 * @Author jiangls
 * @Date 2021/10/20
 */
public interface AbstractBinaryTree<T> {
    boolean isEmpty();

    /**
     * 统计二叉树结点个数
     * @return
     */
    int count();

    /**
     * 返回二叉树的高度（也叫深度）
     */
    int height();

    /**
     * 先序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

    /**
     * 返回node父结点
     */
    BinaryNode<T> getParent(BinaryNode<T> node);

    /**
     * 返回左结点
     * @param node
     * @return
     */
    BinaryNode<T> getLeft(BinaryNode<T> node);

    /**
     * 返回右结点
     * @param node
     * @return
     */
    BinaryNode<T> getRight(BinaryNode<T> node);

    /**
     * 查找并返回首次出现的关键字key元素结点
     */
    BinaryNode<T> search(T key);

    /**
     * 插入根结点
     */
    void insertRoot(T t);

    /**
     * 插入子结点
     * @param p
     * @param t
     * @param lchild
     * @return
     */
    BinaryNode<T> insertChild(BinaryNode<T> p, T t, boolean lchild);

    /**
     * 删除子结点
     * @param p
     * @param lchild
     */
    void removeChild(BinaryNode<T> p, boolean lchild);

    /**
     * 删除二叉树
     */
    void removeAll();

}
