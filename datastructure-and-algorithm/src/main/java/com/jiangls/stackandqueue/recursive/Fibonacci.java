package com.jiangls.stackandqueue.recursive;

/**
 * 使用递归求解Fibonacci数列
 *
 * @Author jiangls
 * @Date 2021/10/19
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fobonacci(12));
    }

    public static int fobonacci(int n) {
        if (n <= 0) {
            return -1;
        }

        // 递归边界
        if(n == 1 || n == 2) {
            return 1;
        }

        // 递推公式
        return fobonacci(n - 1) + fobonacci(n - 2);
    }

}
