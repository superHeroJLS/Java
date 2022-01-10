package com.jiangls.tree;

import com.jiangls.tree.linked.LinkedBinaryTreeGeneric;

/**
 * 测试类
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class Main {
    public static void main(String[] args) {

        /*
            测试使用后序遍历构造二叉树，子树为空用null表示，后序遍历为：null, null, 3, null, null, 4, 1, null, null, 5, null, null, 6, 2, 0
         */
        String[] postOrder = {null, null, "3", null, null, "4", "1", null, null, "5", null, null, "6", "2", "0"};
        BinaryTreeNode<String> rootNode = BinaryTrees.constructByPostOrder(postOrder);
        System.out.println("----------通过后序遍历校验二叉树准确性，预期结果：3 4 1 5 6 2 0");
        BinaryTrees.postOrder(rootNode);

        /*
            测试使用二叉树工具类BinaryTrees先序遍历构造二叉树，子树为空用null表示，先序遍历为：0, 1, 3, null, null, 4, null, null, 2, 5, null, null, 6, null, null
         */
//        String[] preOrder = {"0", "1", "3", null, null, "4", null, null, "2", "5", null, null, "6", null, null};
//        BinaryTreeNode<String> rootNode = BinaryTrees.constructByPreOrder(preOrder);
//        System.out.println("----------通过先序遍历校验二叉树准确性，预期结果：0 1 3 4 2 5 6 ");
//        BinaryTrees.preOrder(rootNode);

        /*
            测试使用后序遍历构造二叉树，子树为空用null表示，后序遍历为：null, null, 3, null, null, 4, 1, null, null, 5, null, null, 6, 2, 0
         */
//        String[] postOrder = {null, null, "3", null, null, "4", "1", null, null, "5", null, null, "6", "2", "0"};
//        LinkedBinaryTreeGeneric<BinaryTreeNode<String>, String> lbt = new LinkedBinaryTreeGeneric<>();
//        lbt.setIdxPostOrder(postOrder.length - 1);
//        BinaryTreeNode<String> rootNode = lbt.constructByPostOrder(postOrder);
//        lbt.setRoot(rootNode);
//        System.out.println("----------通过后序遍历校验二叉树准确性，预期结果：3 4 1 5 6 2 0");
//        lbt.postOrder();

        /*
            测试使用先序遍历构造二叉树，子树为空用null表示，先序遍历为：0, 1, 3, null, null, 4, null, null, 2, 5, null, null, 6, null, null
         */
//        String[] preOrder = {"0", "1", "3", null, null, "4", null, null, "2", "5", null, null, "6", null, null};
//        LinkedBinaryTreeGeneric<BinaryTreeNode<String>, String> lbt = new LinkedBinaryTreeGeneric<>();
//        BinaryTreeNode<String> rootNode = lbt.constructByPreOrder(preOrder);
//        lbt.setRoot(rootNode);
//        System.out.println("----------通过先序遍历校验二叉树准确性，预期结果：0 1 3 4 2 5 6 ");
//        lbt.preOrder();

        /*
            测试使用二叉树工具类BinaryTrees通过中序遍历和后序遍历构造二叉树
         */
//        String[] inOrder = {"3", "1", "4", "0", "5", "2", "6"};
//        String[] postOrder = {"3", "4", "1", "5", "6", "2", "0"};
//        BinaryTreeNode<String> bt = BinaryTrees.constructBinaryTreeByInOrderAndPostOrder(inOrder, postOrder);
//        System.out.println("----------校验通过中序遍历和后序遍历构造出的二叉树准确性----------");
//        BinaryTrees.inOrder(bt);
//        System.out.println();
//        BinaryTrees.postOrder(bt);

        /*
            测试使用二叉树工具类BinaryTrees通过前序遍历和中序遍历构造二叉树
         */
//        String[] preOrder = {"0", "1", "3", "4", "2", "5", "6"};
//        String[] inOrder = {"3", "1", "4", "0", "5", "2", "6"};
//        BinaryTreeNode<String> bt = BinaryTrees.constructBinaryTreeByPreOrderAndInOrder(preOrder, inOrder);
//        System.out.println("----------校验通过前序遍历和中序遍历构造出的二叉树准确性----------");
//        BinaryTrees.inOrder(bt);
//        System.out.println();
//        BinaryTrees.postOrder(bt);

        /*
            测试通过中序遍历和后序遍历构造二叉树
         */
//        LinkedBinaryTreeGeneric<BinaryTreeNode<String>, String> bt = new LinkedBinaryTreeGeneric<>();
//        String[] inOrder = {"3", "1", "4", "0", "5", "2", "6"};
//        String[] postOrder = {"3", "4", "1", "5", "6", "2", "0"};
//        bt.constructBinaryTreeByInOrderAndPostOrder(inOrder, postOrder);
//        System.out.println("----------校验通过中序遍历和后序遍历构造出的二叉树准确性----------");
//        bt.inOrder();
//        System.out.println();
//        bt.postOrder();


        /*
            测试通过前序遍历和中序遍历构造二叉树
         */
//        LinkedBinaryTreeGeneric<BinaryTreeNode<String>, String> bt = new LinkedBinaryTreeGeneric<>();
//        String[] preOrder = {"0", "1", "3", "4", "2", "5", "6"};
//        String[] inOrder = {"3", "1", "4", "0", "5", "2", "6"};
//        bt.constructBinaryTreeByPreOrderAndInOrder(preOrder, inOrder);
//        System.out.println("----------校验通过前序遍历和中序遍历构造出的二叉树准确性----------");
//        bt.preOrder();
//        System.out.println();
//        bt.inOrder();

        /*
            测试对数的换地公式：https://baike.baidu.com/item/%E6%8D%A2%E5%BA%95%E5%85%AC%E5%BC%8F/6731201?fr=aladdin
         */
//        System.out.println(Math.log(7) / Math.log(2));
//        System.out.println(Double.valueOf(Math.log(7) / Math.log(2)).intValue());


        /*
            测试LinkedBinaryTreeGeneric的泛型是否合适，测试过木有问题
         */
//        LinkedBinaryTreeGeneric<BinaryTreeNode<String>, String> bt =
//                new LinkedBinaryTreeGeneric<>("root", new BinaryTreeNode<>("left"), new BinaryTreeNode<>("right"));
//
//        bt.preOrder();
//        bt.inOrder();
//        bt.postOrder();
//
//        System.out.println(bt.height());
    }
}
