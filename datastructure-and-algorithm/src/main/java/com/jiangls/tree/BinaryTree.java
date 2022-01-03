package com.jiangls.tree;

/**
 * @author Jiangls
 * @date 2022/1/3
 */
public class BinaryTree implements AbstractBinaryTree<BinaryTreeNode<Object>> {

    private BinaryTreeNode<Object> root;

    /**
     * 构造空二叉树
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * 构造只有根结点的二叉树
     * @param rootData
     */
    public BinaryTree(Object rootData) {
        this(rootData, null, null);
    }

    public BinaryTree(Object rootData, BinaryTreeNode<Object> lchild, BinaryTreeNode<Object> rchild) {
        this.root = new BinaryTreeNode(rootData, lchild, rchild);
    }

    public BinaryTreeNode<Object> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<Object> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int count() {
        return 0;
    }

    /**
     * 递归求二叉树节点数
     * @param node
     * @return
     */
    private int count(BinaryTreeNode<Object> node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lcount = this.count(node.getLchild());
        int rcount = this.count(node.getRchild());
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
    private int height(BinaryTreeNode<Object> node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lheight = this.height(node.getLchild());
        int rheight = this.height(node.getRchild());

        return lheight > rheight ? 1 + lheight : 1 + rheight;
    }

    @Override
    public void preOrder() {
        this.preOrder(this.root);
    }

    /**
     * 递归前序遍历
     * @param node
     */
    private void preOrder(BinaryTreeNode<Object> node) {
        if (node != null) {
            System.out.print(node.getData().toString() + " ");
            this.preOrder(node.getLchild());
            this.preOrder(node.getRchild());
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
    private void inOrder(BinaryTreeNode<Object> node) {
        if (node != null) {
            this.inOrder(node.getLchild());
            System.out.print(node.getData().toString() + " ");
            this.inOrder(node.getRchild());
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
    private void postOrder(BinaryTreeNode<Object> node) {
        if (node != null) {
            this.inOrder(node.getLchild());
            this.inOrder(node.getRchild());
            System.out.print(node.getData().toString() + " ");
        }
    }

    @Override
    public BinaryTreeNode<Object> getParent(BinaryTreeNode<Object> node) {
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
    private BinaryTreeNode<Object> getParent(BinaryTreeNode<Object> p, BinaryTreeNode<Object> node) {
        if (p == null || node == null) {
            return null;
        }

        if (p.getLchild() == node || p.getRchild() == node) {
            return p;
        }

        BinaryTreeNode<Object> findP = this.getParent(p.getLchild(), node);
        if (findP == null) {
            return this.getParent(p.getRchild(), node);
        }

        return findP;
    }

    @Override
    public BinaryTreeNode<Object> getLeft(BinaryTreeNode<Object> node) {
        return node.getLchild();
    }

    @Override
    public BinaryTreeNode<Object> getRight(BinaryTreeNode<Object> node) {
        return node.getRchild();
    }

    @Override
    public BinaryTreeNode<Object> search(Object key) {
        return null;
    }

    /**
     * 在一棵二叉树中查找数据为key的结点，返回首次出现的数据为key的结点，若未找到返回null。
     * <p>该方法使用先序遍历二叉树进行查找，若一棵二叉树存在多个数据为key结点，返回首次出现的结点，
     * 此时首次出现的次序由二叉树遍历次序决定。</p>
     * @param p
     * @param key
     * @return
     */
    private BinaryTreeNode<Object> search(BinaryTreeNode<Object> p, Object key) {
        if (p == null) {
            return p;
        }

        if (p.getData().equals(key)) {
            return p;
        }

        BinaryTreeNode<Object> findP = this.search(p.getLchild(), key);
        if (findP == null) {
            return this.search(p.getRchild(), key);
        }

        return findP;
    }

    @Override
    public void insertRoot(Object t) {
        this.root = new BinaryTreeNode<>(t);
    }

    @Override
    public BinaryTreeNode<Object> insertChild(BinaryTreeNode<Object> p, Object t, boolean lchild) {
        if (p != null) {
            if (lchild) {
                p.setLchild(new BinaryTreeNode<>(t, null, null));
                return p.getLchild();
            } else {
                p.setRchild(new BinaryTreeNode<>(t, null, null));
                return p.getRchild();
            }
        }

        return null;
    }

    @Override
    public void removeChild(BinaryTreeNode<Object> p, boolean lchild) {
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
        this.removeAll(this.root);
    }

    /**
     * 递归清空二叉树
     * @param node
     */
    private void removeAll(BinaryTreeNode<Object> node) {
        if (node != null) {
            node.setLchild(null);
            node.setRchild(null);
            node = null;
        }
    }
}
