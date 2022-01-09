package com.jiangls.tree.linked;

import com.jiangls.tree.AbstractBinaryTree;
import com.jiangls.tree.BinaryTreeNode;

import java.util.Arrays;

/**
 * 二叉树链式存储实现类型，带有泛型
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class LinkedBinaryTreeGeneric<N extends BinaryTreeNode<E>, E> implements AbstractBinaryTree<N, E> {

    private N root;

    /**
     * 构造空二叉树
     */
    public LinkedBinaryTreeGeneric() {
        this.root = null;
    }

    /**
     * 构造只有根结点的二叉树
     * @param rootData
     */
    public LinkedBinaryTreeGeneric(E rootData) {
        this(rootData, null, null);
    }

    public LinkedBinaryTreeGeneric(E rootData, N lchild, N rchild) {
        this.root = (N) new BinaryTreeNode(rootData, lchild, rchild);
    }

    public N getRoot() {
        return root;
    }

    public void setRoot(N root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int count() {
        return this.count(this.root);
    }

    /**
     * 递归求二叉树节点数
     * @param node
     * @return
     */
    private int count(N node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lcount = this.count((N) node.getLchild());
        int rcount = this.count((N) node.getRchild());
        return 1 + lcount + rcount;

    }

    @Override
    public int height() {
        return this.height(this.root);
    }

    /**
     * 递归求二叉树高度
     * @param node
     * @return
     */
    private int height(N node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lheight = this.height((N) node.getLchild());
        int rheight = this.height((N) node.getRchild());

        return lheight > rheight ? 1 + lheight : 1 + rheight;
    }

    /**
     * 根据先序遍历构造二叉树，二叉树中的空子树以null表示，例如：0, 1, 3, null, null, 4, null, null, 2, 5, null, null, 6, null, null <br>
     * 实际构造出来的二叉树，通过前序遍历打印（不打印null）出来的顺序也为为：0, 1, 3, 2, 5, 6
     * @param preOrder
     */
    private int idxPreOrder = 0;
    public N constructByPreOrder(E[] preOrder) {
        N node = null;
        if (idxPreOrder < preOrder.length) {
            E nodeData = preOrder[idxPreOrder++];
            if (nodeData != null) {
                node = (N) new BinaryTreeNode<E>(nodeData);
                node.setLchild(this.constructByPreOrder(preOrder));
                node.setRchild(this.constructByPreOrder(preOrder));
            }
        }

        return node;
    }

    @Override
    public void preOrder() {
        this.preOrder(this.root);
    }

    /**
     * 递归前序遍历
     * @param node
     */
    private void preOrder(N node) {
        if (node != null) {
            System.out.print(node.getData().toString() + " ");
            this.preOrder((N) node.getLchild());
            this.preOrder((N) node.getRchild());
        }
    }

    @Override
    public void inOrder() {
        this.inOrder(this.root);
    }

    /**
     * 递归中序遍历
     * @param node
     */
    private void inOrder(N node) {
        if (node != null) {
            this.inOrder((N) node.getLchild());
            System.out.print(node.getData().toString() + " ");
            this.inOrder((N) node.getRchild());
        }
    }

    @Override
    public void postOrder() {
        this.postOrder(this.root);
    }

    /**
     * 递归后序遍历
     * @param node
     */
    private void postOrder(N node) {
        if (node != null) {
            this.postOrder((N) node.getLchild());
            this.postOrder((N) node.getRchild());
            System.out.print(node.getData().toString() + " ");
        }
    }

    @Override
    public N getParent(N node) {
        if (this.root == null || node == null || node == this.root) {
            return null;
        }
        return this.getParent(this.root, node);
    }

    /**
     * 使用递归获取某个节点在某个子树的父结点，以现有的这种二叉树的形式，没有办法直接获取一个结点的父结点，
     * 只能通过从根结点遍历来比较获取
     * @param p
     * @param node
     * @return
     */
    private N getParent(N p, N node) {
        if (p == null || node == null) {
            return null;
        }

        if (p.getLchild() == node || p.getRchild() == node) {
            return p;
        }

        N findP = this.getParent((N) p.getLchild(), node);
        if (findP == null) {
            return this.getParent((N) p.getRchild(), node);
        }

        return findP;
    }

    @Override
    public N getLeft(N node) {
        return (N) node.getLchild();
    }

    @Override
    public N getRight(N node) {
        return (N) node.getRchild();
    }

    @Override
    public N search(E key) {
        return this.search(this.root, key);
    }

    /**
     * 在一棵二叉树中查找数据为key的结点，返回首次出现的数据为key的结点，若未找到返回null。
     * <p>该方法使用先序遍历二叉树进行查找，若一棵二叉树存在多个数据为key结点，返回首次出现的结点，
     * 此时首次出现的次序由二叉树遍历次序决定。</p>
     * @param p
     * @param key
     * @return
     */
    private N search(N p, E key) {
        if (p == null) {
            return p;
        }

        if (p.getData().equals(key)) {
            return p;
        }

        N findP = this.search((N) p.getLchild(), key);
        if (findP == null) {
            return this.search((N) p.getRchild(), key);
        }

        return findP;
    }

    @Override
    public void insertRoot(E t) {
        this.root = (N) new BinaryTreeNode(t);
    }

    @Override
    public N insertChild(N p, E t, boolean lchild) {
        if (p != null) {
            if (lchild) {
                p.setLchild(new BinaryTreeNode<>(t, null, null));
                return (N) p.getLchild();
            } else {
                p.setRchild(new BinaryTreeNode<>(t, null, null));
                return (N) p.getRchild();
            }
        }

        return null;
    }

    @Override
    public void removeChild(N p, boolean lchild) {
        if (p != null) {
            if (lchild) {
                p.setLchild(null);
            } else {
                p.setRchild(null);
            }
        }
    }

    @Override
    public void removeAll() {
        this.removeAll();
    }

    /**
     * 递归清空二叉树
     * @param node
     */
    private void removeAll(N node) {
        if (node != null) {
            node.setLchild(null);
            node.setRchild(null);
            node = null;
        }
    }

    /**
     * 根据前序遍历和中序遍历构造出二叉树，构造出来的二叉树可以调用preOrder()和inOrder()方法验证<br>
     *
     * preOrder: C L R          <br>
     * inOrder:  L C R
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public void constructBinaryTreeByPreOrderAndInOrder(E[] preOrder, E[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0) {
            return;
        }
        if (preOrder.length != inOrder.length){
            throw new RuntimeException("前序遍历和中序遍历长度不相同");
        }

        E rootData = preOrder[0];
        // 根节点在中序遍历中的位置下标
        int rootDataIdxInInOrder = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (rootData.equals(inOrder[i])) {
                rootDataIdxInInOrder = i;
                break;
            }
        }
        if (rootDataIdxInInOrder == -1) {
            throw new RuntimeException("前序遍历和中序遍历元素不一致");
        }

        N root = (N) new BinaryTreeNode<E>(rootData);
        // 设置根节点
        this.root = root;

        // 截取左子树的preOrder和inOrder，构造左子树
        E[] lpreOrder = Arrays.copyOfRange(preOrder, 1, rootDataIdxInInOrder + 1);
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByPreOrderAndInOrder(root, lpreOrder, linOrder, true);

        // 截取右子树的preOrder和inOrder，构造右子树
        E[] rpreOrder = Arrays.copyOfRange(preOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        constructBinaryTreeByPreOrderAndInOrder(root, rpreOrder, rinOrder, false);
    }

    /**
     *
     * preOrder: C L R          <br>
     * inOrder:  L C R
     *
     * @param parent
     * @param preOrder
     * @param inOrder
     * @param isLeft
     */
    private void constructBinaryTreeByPreOrderAndInOrder(N parent, E[] preOrder, E[] inOrder, boolean isLeft) {
        if (preOrder == null || inOrder == null || preOrder.length == 0) {
            return;
        }
        if (preOrder.length != inOrder.length){
            throw new RuntimeException("前序遍历和中序遍历长度不相同");
        }

        E nodeData = preOrder[0];
        // 根节点在中序遍历中的位置下标
        int rootDataIdxInInOrder = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (nodeData.equals(inOrder[i])) {
                rootDataIdxInInOrder = i;
                break;
            }
        }
        if (rootDataIdxInInOrder == -1) {
            throw new RuntimeException("前序遍历和中序遍历元素不一致");
        }

        // new出一个二叉树节点
        N node = (N) new BinaryTreeNode<E>(nodeData);

        // 根据isLeft设置node为parent的子节点
        if (isLeft) {
            parent.setLchild(node);
        } else {
            parent.setRchild(node);
        }

        // 截取左子树的preOrder和inOrder，构造左子树
        E[] lpreOrder = Arrays.copyOfRange(preOrder, 1, rootDataIdxInInOrder + 1);
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByPreOrderAndInOrder(node, lpreOrder, linOrder, true);

        // 截取右子树的preOrder和inOrder，构造右子树
        E[] rpreOrder = Arrays.copyOfRange(preOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        constructBinaryTreeByPreOrderAndInOrder(node, rpreOrder, rinOrder, false);
    }

    /**
     * 根据中序遍历和后序遍历构造出二叉树，构造出来的二叉树可以调用inOrder()和postOrder()方法验证<br>
     *
     * inOrder   : L C R          <br>
     * postOrder:  L R C
     *
     * @param inOrder
     * @param postOrder
     * @return
     */
    public void constructBinaryTreeByInOrderAndPostOrder(E[] inOrder, E[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length == 0) {
            return;
        }
        if (inOrder.length != postOrder.length){
            throw new RuntimeException("中序遍历和后序遍历长度不相同");
        }

        E rootData = postOrder[postOrder.length - 1];
        // 根节点在中序遍历中的位置下标
        int rootDataIdxInInOrder = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (rootData.equals(inOrder[i])) {
                rootDataIdxInInOrder = i;
                break;
            }
        }
        if (rootDataIdxInInOrder == -1) {
            throw new RuntimeException("中序遍历和后序遍历元素不一致");
        }

        N root = (N) new BinaryTreeNode<E>(rootData);
        // 设置根节点
        this.root = root;

        // 截取左子树的inOrder和postOrder，构造左子树
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        E[] lpostOrder = Arrays.copyOfRange(postOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByInOrderAndPostOrder(root, linOrder, lpostOrder, true);

        // 截取右子树的inOrder和postOrder，构造右子树
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rpostOrder = Arrays.copyOfRange(postOrder, rootDataIdxInInOrder, postOrder.length - 1);
        constructBinaryTreeByInOrderAndPostOrder(root, rinOrder, rpostOrder, false);
    }

    /**
     * inOrder   : L C R          <br>
     * postOrder:  L R C
     *
     * @param parent
     * @param inOrder
     * @param postOrder
     * @param isLeft
     */
    private void constructBinaryTreeByInOrderAndPostOrder(N parent, E[] inOrder, E[] postOrder, boolean isLeft) {
        if (inOrder == null || inOrder == null || inOrder.length == 0) {
            return;
        }
        if (inOrder.length != postOrder.length){
            throw new RuntimeException("中序遍历和后序遍历长度不相同");
        }

        E nodeData = postOrder[postOrder.length - 1];
        // 根节点在中序遍历中的位置下标
        int rootDataIdxInInOrder = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (nodeData.equals(inOrder[i])) {
                rootDataIdxInInOrder = i;
                break;
            }
        }
        if (rootDataIdxInInOrder == -1) {
            throw new RuntimeException("中序遍历和后序遍历元素不一致");
        }

        // new出一个二叉树节点
        N node = (N) new BinaryTreeNode<E>(nodeData);

        // 根据isLeft设置node为parent的子节点
        if (isLeft) {
            parent.setLchild(node);
        } else {
            parent.setRchild(node);
        }

        // 截取左子树的inOrder和postOrder，构造左子树
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        E[] lpostOrder = Arrays.copyOfRange(postOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByInOrderAndPostOrder(node, linOrder, lpostOrder, true);

        // 截取右子树的inOrder和postOrder，构造右子树
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rpostOrder = Arrays.copyOfRange(postOrder, rootDataIdxInInOrder, postOrder.length - 1);
        constructBinaryTreeByInOrderAndPostOrder(node, rinOrder, rpostOrder, false);
    }
}
