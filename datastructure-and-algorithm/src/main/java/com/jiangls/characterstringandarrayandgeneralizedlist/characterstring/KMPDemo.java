package com.jiangls.characterstringandarrayandgeneralizedlist.characterstring;

/**
 * <p>KMP算法demo，KMP算法是一种无回溯的的模式匹配算法，目标串不回溯，改进了Brute-Force算法</p>
 * <p>Knuth-Morris-Pratt算法（简称KMP）是最常用的之一。它以三个发明者命名，起头的那个K就是著名科学家Donald Knuth</p>
 *
 * <p>参考：<a href=https://www.cnblogs.com/yjiyjige/p/3263858.html>https://www.cnblogs.com/yjiyjige/p/3263858.html</a></p>
 * @Author jiangls
 * @Date 2021/10/19
 */
public class KMPDemo {
    public static void main(String[] args) {

    }

    public static int indexOf(String target, String pattern, int begin) {
        char[] t = target.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(pattern);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                j = next[j]; // j回到指定位置
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
