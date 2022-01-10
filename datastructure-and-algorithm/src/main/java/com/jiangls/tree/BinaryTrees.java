package com.jiangls.tree;

import java.util.Arrays;

/**
 * 二叉树工具类
 *
 * @author Jiangls
 * @date 2022/1/9
 */
public class BinaryTrees {

    public BinaryTrees() {
    }

    /**
     * 根据<b>先序遍历</b>构造二叉树，二叉树中的<b>空子树以null</b>表示，例如：0, 1, 3, null, null, 4, null, null, 2, 5, null, null, 6, null, null <br>
     * 实际构造出来的二叉树，通过前序遍历打印（不打印null）出来的顺序也为为：0, 1, 3, 2, 5, 6 <br>
     *
     * <b>无法通过中序遍历构造二叉树</b>
     *
     * @param preOrder
     * @param <N>
     * @param <E>
     * @return
     */
    public static <N extends BinaryTreeNode<E>, E> N constructByPreOrder(E[] preOrder) {
        N root = null;
        int idxPreOrder = 0;
        if (preOrder.length > 0) {
            E rootData = preOrder[idxPreOrder++];
            if (rootData != null) {
                root = (N) new BinaryTreeNode<E>(rootData);
                idxPreOrder = constructByPreOrder(root, preOrder, idxPreOrder, true);
                idxPreOrder = constructByPreOrder(root, preOrder, idxPreOrder, false);
            }
        }
        return root;
    }

    private static <N extends BinaryTreeNode<E>, E> int constructByPreOrder(N parent, E[] preOrder, int idxPreOrder, boolean isLeft) {
        if (idxPreOrder < preOrder.length) {
            E nodeData = preOrder[idxPreOrder++];
            if (nodeData != null) {
                N node = (N) new BinaryTreeNode<E>(nodeData);
                if (isLeft) {
                    parent.setLchild(node);
                } else {
                    parent.setRchild(node);
                }
                idxPreOrder = constructByPreOrder(node, preOrder, idxPreOrder, true);
                idxPreOrder = constructByPreOrder(node, preOrder, idxPreOrder, false);
            }
        }
        return idxPreOrder;
    }



    /**
     * 递归前序遍历
     * @param node
     */
    public static <N extends BinaryTreeNode> void preOrder(N node) {
        if (node != null) {
            System.out.print(node.getData().toString() + " ");
            preOrder(node.getLchild());
            preOrder(node.getRchild());
        }
    }

    /**
     * 递归中序遍历
     * @param node
     */
    public static <N extends BinaryTreeNode> void inOrder(N node) {
        if (node != null) {
            inOrder(node.getLchild());
            System.out.print(node.getData().toString() + " ");
            inOrder(node.getRchild());
        }
    }

    /**
     * 递归后序遍历
     * @param node
     */
    public static <N extends BinaryTreeNode> void postOrder(N node) {
        if (node != null) {
            postOrder(node.getLchild());
            postOrder(node.getRchild());
            System.out.print(node.getData().toString() + " ");
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
    public static <N extends BinaryTreeNode<E>, E> N constructBinaryTreeByPreOrderAndInOrder(E[] preOrder, E[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0) {
            return null;
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

        // 截取左子树的preOrder和inOrder，构造左子树
        E[] lpreOrder = Arrays.copyOfRange(preOrder, 1, rootDataIdxInInOrder + 1);
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByPreOrderAndInOrder(root, lpreOrder, linOrder, true);

        // 截取右子树的preOrder和inOrder，构造右子树
        E[] rpreOrder = Arrays.copyOfRange(preOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        constructBinaryTreeByPreOrderAndInOrder(root, rpreOrder, rinOrder, false);

        return root;
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
    private static <N extends BinaryTreeNode<E>, E> void constructBinaryTreeByPreOrderAndInOrder(N parent, E[] preOrder, E[] inOrder, boolean isLeft) {
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
    public static <N extends BinaryTreeNode<E>, E> N constructBinaryTreeByInOrderAndPostOrder(E[] inOrder, E[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length == 0) {
            return null;
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

        // 截取左子树的inOrder和postOrder，构造左子树
        E[] linOrder = Arrays.copyOfRange(inOrder, 0, rootDataIdxInInOrder);
        E[] lpostOrder = Arrays.copyOfRange(postOrder, 0, rootDataIdxInInOrder);
        constructBinaryTreeByInOrderAndPostOrder(root, linOrder, lpostOrder, true);

        // 截取右子树的inOrder和postOrder，构造右子树
        E[] rinOrder = Arrays.copyOfRange(inOrder, rootDataIdxInInOrder + 1, inOrder.length);
        E[] rpostOrder = Arrays.copyOfRange(postOrder, rootDataIdxInInOrder, postOrder.length - 1);
        constructBinaryTreeByInOrderAndPostOrder(root, rinOrder, rpostOrder, false);

        return root;
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
    private static <N extends BinaryTreeNode<E>, E> void constructBinaryTreeByInOrderAndPostOrder(N parent, E[] inOrder, E[] postOrder, boolean isLeft) {
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
