package com.jiangls.indexing;

/**
 * 平衡二叉树，也称之为AVL树，百度释义：
 * <a href="https://baike.baidu.com/item/AVL%E6%A0%91/10986648?fr=aladdin">https://baike.baidu.com/item/AVL%E6%A0%91/10986648?fr=aladdin</a>
 * @author Jiangls
 * @date 2023/4/25
 */
public class BalancedBinarySortTree {

    public static void main(String[] args) {
        // 构造
        BbstNode node = insert(null, 9);
        node = insert(node, 8);
        node = insert(node, 7);
        node = insert(node, 6);
        node = insert(node, 5);
        node = insert(node, 4);
        node = insert(node, 3);
        node = insert(node, 2);
        node = insert(node, 1);

        // 中序
        inorder(node);

        // 删除
        del(node, 5);

        // 中序
        System.out.println("-----删除后中序");
        inorder(node);

    }

    /**
     * 获取节点高度
     * @param node 树节点
     * @return
     */
    public static int height(BbstNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点平衡因子
     * @param node 树节点
     * @return
     */
    public static int balanceFactor(BbstNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.lchild) - height(node.rchild);
    }

    /**
     * 右旋
     * @param y 待右旋节点
     * @return
     */
    public static BbstNode rotateRight(BbstNode y) {
        BbstNode x = y.lchild;
        BbstNode tmp = x.rchild;

        x.rchild = y;
        y.lchild = tmp;

        y.height = Math.max(height(y.lchild), height(y.rchild)) + 1;
        x.height = Math.max(height(x.lchild), height(x.rchild)) + 1;

        return x;
    }

    /**
     * 左旋
     * @param x 待左旋节点
     * @return
     */
    public static BbstNode rotateLeft(BbstNode x) {
        BbstNode y = x.rchild;
        BbstNode tmp = y.lchild;

        y.lchild = x;
        x.rchild = tmp;

        x.height = Math.max(height(x.lchild), height(x.rchild)) + 1;
        y.height = Math.max(height(y.lchild), height(y.rchild)) + 1;

        return y;
    }

    /**
     * 平衡二叉树在插入结点后，可能变成不平衡需要调整。其调整方法如下：
     *
     * <br>找到离插入结点最近且平衡因子绝对值超过1的祖先结点，以该结点为根的子树称为最小不平衡子树，对该子树进行平衡调整按照其调整规律可归纳为以下四种情况。
     *
     * <ol>
     *      <li>LL型</li>
     *      <li>RR型</li>
     *      <li>LR型</li>
     *      <li>RL型</li>
     * </ol>
     * @param node 平衡二叉树根节点
     * @param key
     * @return 新增节点后的二叉树根节点
     */
    public static BbstNode insert(BbstNode node, Integer key) {
        if (node == null) {
            return new BbstNode(key, null, null, 1);
        }

        if (key < node.data) {
            node.lchild = insert(node.lchild, key);
        } else if (key > node.data) {
            node.rchild = insert(node.rchild, key);
        } else {
            return node;
        }

        // 节点高度
        node.height = 1 + Math.max(height(node.lchild), height(node.rchild));

        // 节点平衡因子
        int balance = balanceFactor(node);

        // LL型，右旋
        if (balance > 1 && key < node.lchild.data) {
            return rotateRight(node);
        }

        // RR型，左旋
        if (balance < -1 && key > node.rchild.data) {
            return rotateLeft(node);
        }

        // LR型，节点左字树左旋，节点右旋
        if (balance > 1 && key > node.lchild.data) {
            node.lchild = rotateLeft(node.lchild);
            return rotateRight(node);
        }

        // RL型，节点右字数右旋，节点左旋
        if (balance < -1 && key < node.rchild.data) {
            node.rchild = rotateRight(node.rchild);
            return rotateLeft(node);
        }

        return node;
    }

    public static BbstNode minValueNode(BbstNode node) {
        BbstNode current = node;
        while (current.lchild != null) {
            current = current.lchild;
        }
        return current;
    }

    /**
     * 平衡二叉树在删除结点后，可能变成不平衡需要调整。其调整方法如下：
     *
     * <br>找到离删除结点最近且平衡因子绝对值超过1的祖先结点，以该结点为根的子树称为最小不平衡子树，对该子树进行平衡调整按照其调整规律可归纳为以下四种情况。
     *
     * <ol>
     *     删除和插入类似但是不完全一样
     *      <li>LL型</li>
     *      <li>RR型</li>
     *      <li>LR型</li>
     *      <li>RL型</li>
     * </ol>
     * @param node 平衡二叉树根节点
     * @param key
     * @return 删除节点后的平衡二叉树根节点
     */
    public static BbstNode del(BbstNode node, Integer key) {
        if (node == null) {
            return node;
        }

        if (key < node.data) {
            node.lchild = del(node.lchild, key);
        } else if (key > node.data) {
            node.rchild = del(node.rchild, key);
        } else {
            if ((node.lchild == null) || (node.rchild == null)) {
                BbstNode temp = null;
                if (temp == node.lchild) {
                    temp = node.rchild;
                } else {
                    temp = node.lchild;
                }

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                BbstNode temp = minValueNode(node.rchild);
                node.data = temp.data;
                node.rchild = del(node.rchild, temp.data);
            }
        }

        if (node == null) {
            return node;
        }

        // 节点高度
        node.height = Math.max(height(node.lchild), height(node.rchild)) + 1;

        int balance = balanceFactor(node);

        // LL型，右旋
        if (balance > 1 && balanceFactor(node.lchild) >= 0) {
            return rotateRight(node);
        }

        // LR型，节点左子树左旋，节点右旋
        if (balance > 1 && balanceFactor(node.lchild) < 0) {
            node.lchild = rotateLeft(node.lchild);
            return rotateRight(node);
        }

        // RR型，左旋
        if (balance < -1 && balanceFactor(node.rchild) <= 0) {
            return rotateLeft(node);
        }

        // RL型，节点you右子树右旋，节点左旋
        if (balance < -1 && balanceFactor(node.rchild) > 0) {
            node.rchild = rotateRight(node.rchild);
            return rotateLeft(node);
        }

        return node;
    }

    /**
     * 查找
     * <ol>
     *     <li>若平衡二叉树为空返回null；</li>
     *     <li>若key等于当前节点返回当前节点；</li>
     *     <li>若key大于当前节点，递归查找右子树；</li>
     *     <li>若key小于当前节点，递归查找左子树</li>
     * </ol>
     * @param node 必须为平衡二叉树根节点
     * @param key
     * @return 查找到的节点
     */
    public static BbstNode search(BbstNode node, Integer key) {
        System.out.println("查找node-key:" + node  + "-" + key + "-----");
        if (node == null) {
            return null;
        } else if (key.equals(node.data)) {
            return node;
        } else if (key.compareTo(node.data) > 0) {
            // 关键字大于当前节点，递归右子树
            return search(node.rchild, key);
        } else {
            // 递归左子树
            return search(node.lchild, key);
        }
    }

    /**
     * 中序遍历平衡二叉树
     * @param node 平衡二叉树根节点
     */
    public static void inorder(BbstNode node) {
        if (node.lchild != null) {
            inorder(node.lchild);
        }
        System.out.println(node.data);
        if (node.rchild != null) {
            inorder(node.rchild);
        }
    }
}

class BbstNode {
    /**
     * 数据
     */
    public Integer data;
    /**
     * 左、右子树
     */
    public BbstNode lchild;
    public BbstNode rchild;
    /**
     * 节点树高度
     */
    public int height;

    public BbstNode(Integer data, BbstNode lchild, BbstNode rchild, int height) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
        this.height = height;
    }
}
