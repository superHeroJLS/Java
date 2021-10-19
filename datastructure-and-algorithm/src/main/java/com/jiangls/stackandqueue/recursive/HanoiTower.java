package com.jiangls.stackandqueue.recursive;

/**
 * 汉诺塔问题
 *
 * @Author jiangls
 * @Date 2021/10/19
 */
public class HanoiTower {
    public static void main(String[] args) {
        move(4, 'A', 'B', 'C');
    }

    public static void move(int n, char a, char b, char c) {
        // 只有一个盘子，直接移动到c柱，递归边界
        if (n == 1) {
            System.out.println("盘" + n + ": " + a + "->" + c);
        } else {
            // 移动n-1个盘子，由a柱到b柱，借助c柱
            move(n - 1, a, c, b);
            System.out.println("盘" + n + ": " + a + "->" + c);
            // 移动n-1个盘子，由b柱到c柱，借助a柱
            move(n - 1, b, a, c);
        }
    }
}
