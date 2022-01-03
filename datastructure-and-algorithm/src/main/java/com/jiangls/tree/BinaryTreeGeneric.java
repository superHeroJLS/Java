package com.jiangls.tree;

/**
 * 二叉树类型，带有泛型
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class BinaryTreeGeneric<T extends BinaryTreeNode<E>, E> implements AbstractBinaryTree<T, E> {

    private T root;

    /**
     * 构造空二叉树
     */
    public BinaryTreeGeneric() {
        this.root = null;
    }

    /**
     * 构造只有根结点的二叉树
     * @param rootData
     */
    public BinaryTreeGeneric(E rootData) {
        this(rootData, null, null);
    }

    public BinaryTreeGeneric(E rootData, T lchild, T rchild) {
        this.root = (T) new BinaryTreeNode(rootData, lchild, rchild);
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
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
    private int count(T node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lcount = this.count((T) node.getLchild());
        int rcount = this.count((T) node.getRchild());
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
    private int height(T node) {
        // 递归边界
        if (node == null) {
            return 0;
        }

        // 递推公式
        int lheight = this.height((T) node.getLchild());
        int rheight = this.height((T) node.getRchild());

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
    private void preOrder(T node) {
        if (node != null) {
            System.out.print(node.getData().toString() + " ");
            this.preOrder((T) node.getLchild());
            this.preOrder((T) node.getRchild());
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
    private void inOrder(T node) {
        if (node != null) {
            this.inOrder((T) node.getLchild());
            System.out.print(node.getData().toString() + " ");
            this.inOrder((T) node.getRchild());
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
    private void postOrder(T node) {
        if (node != null) {
            this.inOrder((T) node.getLchild());
            this.inOrder((T) node.getRchild());
            System.out.print(node.getData().toString() + " ");
        }
    }

    @Override
    public T getParent(T node) {
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
    private T getParent(T p, T node) {
        if (p == null || node == null) {
            return null;
        }

        if (p.getLchild() == node || p.getRchild() == node) {
            return p;
        }

        BinaryTreeNode<E> findP = this.getParent((T) p.getLchild(), node);
        if (findP == null) {
            return this.getParent((T) p.getRchild(), node);
        }

        return (T) findP;
    }

    @Override
    public T getLeft(T node) {
        return (T) node.getLchild();
    }

    @Override
    public T getRight(T node) {
        return (T) node.getRchild();
    }

    @Override
    public T search(E key) {
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
    private T search(T p, E key) {
        if (p == null) {
            return p;
        }

        if (p.getData().equals(key)) {
            return p;
        }

        T findP = this.search((T) p.getLchild(), key);
        if (findP == null) {
            return this.search((T) p.getRchild(), key);
        }

        return findP;
    }

    @Override
    public void insertRoot(E t) {
        this.root = (T) new BinaryTreeNode(t);
    }

    @Override
    public T insertChild(T p, E t, boolean lchild) {
        if (p != null) {
            if (lchild) {
                p.setLchild(new BinaryTreeNode<>(t, null, null));
                return (T) p.getLchild();
            } else {
                p.setRchild(new BinaryTreeNode<>(t, null, null));
                return (T) p.getRchild();
            }
        }

        return null;
    }

    @Override
    public void removeChild(T p, boolean lchild) {
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
    private void removeAll(T node) {
        if (node != null) {
            node.setLchild(null);
            node.setRchild(null);
            node = null;
        }
    }
}
