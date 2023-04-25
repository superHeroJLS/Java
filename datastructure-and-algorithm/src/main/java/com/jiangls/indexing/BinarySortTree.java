package com.jiangls.indexing;

/**
 * 二叉排序树
 *
 * @author Jiangls
 * @date 2023/4/23
 */
public class BinarySortTree<T> {

    public static void main(String[] args) throws InterruptedException {
        // 构造
        BstNode node = insert(null, 4);
        insert(node, 3);
        insert(node, 2);
        insert(node, 1);
        insert(node, 5);
        insert(node, 6);
        insert(node, 7);
        insert(node, 8);
        insert(node, 9);

        // 中序
        System.out.println("-----中序");
        inorder(node);
        Thread.sleep(200);

        // 查找
        System.out.println("-----查找");
        BstNode target = search(node, 5);
        System.out.println("Target node: " + target + "-" + target.data);
        Thread.sleep(200);

        // 删除
        System.out.println("-----删除后中序");
        del(node, 5);
        // 中序
        inorder(node);
        Thread.sleep(200);

        // 查找
        System.out.println("-----删除后查找");
        target = search(node, 5);
        System.out.println("Target node: " + target);
        Thread.sleep(200);

        // 插入
        System.out.println("-----插入后中序");
        insert(node, 11);
        inorder(node);
        Thread.sleep(200);

    }

    /**
     * 插入</br>
     * <ol>
     *     <li>若二叉排序树为空，新增根节点</li>
     *     <li>二叉排序树不为空，关键字key等于node关键字，无需插入</li>
     *     <li>二叉排序树不为空，关键字key大于node关键字，key递归插入到右子树中</li>
     *     <li>二叉排序树不为空，关键字key小于node关键字，key递归插入到左子树中</li>
     * </ol>
     * @param node 二叉排序树根节点
     * @param key
     * @return 返回插入的节点
     */
    public static BstNode insert(BstNode node, Integer key) {
        if (node == null) {
            node = new BstNode(key, null, null);
            return node;
        } else if (key.equals(node.data)) {
            return node;
        } else if (key.compareTo(node.data) > 0) {
            if (node.rchild == null) {
                BstNode r = new BstNode(key, null, null);
                node.rchild = r;
                return r;
            } else {
                return insert(node.rchild, key);
            }
        } else {
            if (node.lchild == null) {
                BstNode l = new BstNode(key, null, null);
                node.lchild = l;
                return l;
            } else {
                return insert(node.lchild, key);
            }
        }
    }

    /**
     * 删除节点，首先查找节点，然后删除节点。返回删除
     * <ol>
     *     删除节点分3中情况
     *     <li>节点没有左右子树（叶子节点）</li>
     *     <li>节点只有左子树</li>
     *     <li>节点只有右子树</li>
     *     <li>节点既有左子树、也有右子树</li>
     * </ol>
     * @param node 二叉排序树根节点
     * @param key
     * @return 删除节点后的二叉排序树根节点
     */
    public static BstNode del(BstNode node, Integer key) {
        if (node == null) {
            return null;
        }
        // 查找
        BstNode targetNode = search(node, key);

        if (targetNode == null) {
            // 未找到，不执行操作
            System.out.println("未找到要删除的节点");
        } else {
            // 找到
            BstNode parentNode = getParent(node, key);
            if (parentNode == null) {
                // targetNode为根节点
                node = null;
            } else {
                // targetNode不为根节点

                // 1 targetNode没有左右子树（叶子节点）
                if (targetNode.lchild == null && targetNode.rchild == null) {
                    if (targetNode.equals(parentNode.lchild)) {
                        // targetNode为父节点的左子树
                        parentNode.lchild = null;
                    } else {
                        // targetNode为父节点的右子树
                        parentNode.rchild = null;
                    }
                } else if (targetNode.lchild != null && targetNode.rchild == null) {
                    // 2 targetNode只有左子树
                    if (targetNode.equals(parentNode.lchild)) {
                        // targetNode为父节点的左子树
                        parentNode.lchild = targetNode.lchild;
                    } else {
                        // targetNode为父节点的右子树
                        parentNode.rchild = targetNode.lchild;
                    }
                } else if (targetNode.lchild == null && targetNode.rchild != null) {
                    // 3 targetNode只有右子树
                    if (targetNode.equals(parentNode.lchild)) {
                        // targetNode为父节点的左子树
                        parentNode.lchild = targetNode.rchild;
                    } else {
                        // targetNode为父节点的右子树
                        parentNode.rchild = targetNode.rchild;
                    }
                } else {
                    // 4 targetNode有左子树和右子树

                    // targetNode为父节点的左子树或右子树

                    // 找到targetNode右子树最小节点rMinNode，保存rMinNode的关键字rMinkey，删除rMinNode
                    BstNode rMinParentNode = targetNode;
                    BstNode rMinNode = targetNode.lchild;
                    while (rMinNode.lchild != null) {
                        rMinParentNode = rMinNode;
                        rMinNode = rMinNode.lchild;
                    }
                    int rMinkey = rMinNode.data;
                    rMinParentNode.lchild = null;
                    // targetNode关键字赋值为rMinKey即可
                    targetNode.data = rMinkey;
                }
            }
        }

        return node;
    }

    /**
     * 查找关键字key的父节点，保证key一定可以在二叉排序树中是存在的
     *
     * @param node 二叉排序树根节点
     * @param key 关键字key，一定在二叉排序树中存在
     * @return
     */
    private static BstNode getParent(BstNode node, Integer key) {
        BstNode parent = null;
        BstNode target = node;

        while (!target.data.equals(key)) {
            parent = target;
            if (key.compareTo(target.data) > 0) {
                target = target.rchild;
            } else {
                target = target.lchild;
            }
        }

        return parent;
    }

    /**
     * 查找
     * <ol>
     *     <li>若二叉排序树为空返回null；</li>
     *     <li>若key等于当前节点返回当前节点；</li>
     *     <li>若key大于当前节点，递归查找右子树；</li>
     *     <li>若key小于当前节点，递归查找左子树</li>
     * </ol>
     * @param node 必须为二叉排序根节点
     * @param key
     * @return 查找到的节点
     */
    public static BstNode search(BstNode node, Integer key) {
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
     * 中序遍历二叉排序树
     * @param node 二叉排序树根节点
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

/**
 * 二叉排序树节点
 */
class BstNode {
    /**
     * 节点数据
     */
    public Integer data;
    /**
     * 左右子节点
     */
    public BstNode lchild, rchild;

    public BstNode(Integer data, BstNode lchild, BstNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}
