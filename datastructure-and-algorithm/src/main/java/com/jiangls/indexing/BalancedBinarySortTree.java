package com.jiangls.indexing;

/**
 * 平衡二叉树，也称之为AVL树，百度释义：
 * <a href="https://baike.baidu.com/item/AVL%E6%A0%91/10986648?fr=aladdin">https://baike.baidu.com/item/AVL%E6%A0%91/10986648?fr=aladdin</a>
 * @author Jiangls
 * @date 2023/4/25
 */
public class BalancedBinarySortTree {

    /**
     * 平衡二叉树在插入结点后，可能变成不平衡需要调整。其调整方法如下：
     *
     * <br>找到离插入结点最近且平衡因子绝对值超过1的祖先结点，以该结点为根的子树称为最小不平衡子树，对该子树进行平衡调整按照其调整规律可归纳为以下四种情况。
     *
     * <ol>
     *      <li>LL型，新增节点的父节点是左节点，新增节点为左节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行LL调整</li>
     *      <li>RR型，新增节点的父节点是右节点，新增节点为右节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行RR调整</li>
     *      <li>LR型，新增节点的父节点是左节点，新增节点为右节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行LR调整</li>
     *      <li>RL型，新增节点的父节点是右节点，新增节点为左节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行RL调整</li>
     * </ol>
     * @param node 平衡二叉树根节点
     * @param key
     * @return 返回插入的节点
     */
    public static BbstNode insert(BbstNode node, Integer key) {

        return null;
    }

    /**
     * 平衡二叉树在删除结点后，可能变成不平衡需要调整。其调整方法如下：
     *
     * <br>找到离删除结点最近且平衡因子绝对值超过1的祖先结点，以该结点为根的子树称为最小不平衡子树，对该子树进行平衡调整按照其调整规律可归纳为以下四种情况。
     *
     * <ol>
     *     删除和插入类似，但不完全一样需要自行画图分析理解一遍：
     *      <li>LL型，新增节点的父节点是左节点，删除节点为右节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行LL调整</li>
     *      <li>RR型，新增节点的父节点是右节点，删除节点为左节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行RR调整</li>
     *      <li>LR型，新增节点的父节点是左节点，新增节点为左节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行LR调整</li>
     *      <li>RL型，新增节点的父节点是右节点，新增节点为右节点：向上重新计算parent节点bf因子，当出现bf > 1的情况时，马上进行RL调整</li>
     * </ol>
     * @param node 平衡二叉树根节点
     * @param key
     * @return 删除节点后的平衡二叉树根节点
     */
    public static BbstNode del(BbstNode node, Integer key) {

        return null;
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
    public static void inorder(BstNode node) {
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
     * 平衡因子，大于1时调整平衡二叉树
     */
    public int bf;

    public BbstNode(Integer data, BbstNode lchild, BbstNode rchild, int bf) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
        this.bf = bf;
    }
}
