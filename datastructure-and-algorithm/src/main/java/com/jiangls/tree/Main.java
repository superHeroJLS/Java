package com.jiangls.tree;

/**
 * 测试类
 *
 * @author Jiangls
 * @date 2022/1/3
 */
public class Main {
    public static void main(String[] args) {

        /*
            测试对数的换地公式：https://baike.baidu.com/item/%E6%8D%A2%E5%BA%95%E5%85%AC%E5%BC%8F/6731201?fr=aladdin
         */
        System.out.println(Math.log(7) / Math.log(2));
        System.out.println(Double.valueOf(Math.log(7) / Math.log(2)).intValue());


        // 测试BinaryTreeGeneric的泛型是否合适
//        BinaryTreeGeneric<BinaryTreeNode<String>, String> bt = new BinaryTreeGeneric<>();
//        bt.setRoot(new BinaryTreeNode<>("root"));
//
//        System.out.println(bt.height());
    }
}
