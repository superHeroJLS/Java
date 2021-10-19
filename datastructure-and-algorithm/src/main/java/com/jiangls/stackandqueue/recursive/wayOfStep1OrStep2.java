package com.jiangls.stackandqueue.recursive;

/**
 * 假设有n个台阶，每次可以跨越一个或者两个台阶，若要找出n个台阶有多少种走法，请用递归求解。
 *
 * <p>参考：<a href=https://www.zhihu.com/question/358819329>https://www.zhihu.com/question/358819329</a></p><br/>
 *
 * <p>这是关于斐波那契数列(Fibonacci Sequence)的问题。若记到达第n级台阶的方式数量way(n)：
 * <ul>
 *     <li>最后一次上了1阶，意味着倒数第二次是到达了第n-1阶，这种方式共有way(n-1)种</li>
 *     <li>最后一次上了2阶，意味着倒数第二次是到达了第n-2阶，这种方式共有way(n-2)种</li>
 * </ul>
 * </p>
 * @Author jiangls
 * @Date 2021/10/19
 */
public class wayOfStep1OrStep2 {
    public static void main(String[] args) {
        System.out.println(way(5));
    }

    public static int way(int n) {
        if(n <= 0) {
            return -1;
        }

        // 递归边界
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        // 递推公式
        return way(n - 1) + way(n - 2);
    }
}
