package com.jiangls.tree;

/**
 * 测试类
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class Main {
    public static void main(String[] args) {

        // 测试BinaryTreeGeneric的泛型是否合适
        BinaryTreeGeneric<BinaryTreeNode<String>, String> bt = new BinaryTreeGeneric<>();
        bt.setRoot(new BinaryTreeNode<>("root"));

        System.out.println(bt.height());
    }
}
