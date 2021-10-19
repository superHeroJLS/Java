package com.jiangls.characterstringandarrayandgeneralizedlist.characterstring;

/**
 * Brute-Force算法demo，BF算法的基本思想是蛮力匹配，从目标串的target的每一个字符开始依次与模式串pattern的字符进行比较
 * @Author jiangls
 * @Date 2021/10/19
 */
public class BFDemo {
    public static void main(String[] args) {
        int index = indexOf("aababcd", "abcd", 0);
        System.out.println("index: " + index);
    }

    /**
     * @param target    目标串
     * @param pattern   匹配串
     * @param begin     目标串开始匹配位置
     * @return
     */
    public static int indexOf(String target, String pattern, int begin) {
        if (begin < 0) {
            begin = 0;
        }

        int tl = target.length(), pl = pattern.length();

        int ti = begin, pj = 0;
        // 比较次数
        int count = 0;

        if (tl >= pl) {
            while(ti < tl && pj < pl) {
                // 字符相等
                if (target.charAt(ti) == pattern.charAt(pj)){
                    ti++;
                    pj++;
                } else {
                    ti = ti - pj + 1;   // target串下标ti，退回到下个匹配字串序号
                    pj = 0; // pattern串下标pj，退回到0
                    if (ti > tl - pl) { // target剩余子串的长度<m，不再比较
                        break;
                    }
                }

                count++;
            }

        }

        System.out.println("count total: " + count);
        if (pj == pl) {
            return ti - pj;
        }

        return -1;
    }


}
