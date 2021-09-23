package com.jiangls.interview;

import java.util.Arrays;

public class ArrayAddtion {
    public static void main(String[] args) {
        int[] a = {1,2,3,8,6};
        int[] b = {4,5,7,9,9};

        int[] sum = sum(a, b);
        System.out.println("sum: " + Arrays.toString(sum));
    }

    /**
     * a 和 b 长度一致，长度可能超过1000
     * a [1,2,3]  -> 123;   b [4,5,7] -> 457
     * sum = a+b = 580
     * 返回结果：result [5,8,0]
     * @param a
     * @param b
     * @return
     */
    public static int[] sum(int[] a, int[] b) {
        int[] sum = new int[a.length+1];

        // 进位标志
        boolean mark = false;
        for (int i = a.length-1; i >= 0; i--) {
            // 逐位相加
            int tmp;
            if (mark) {
                tmp = a[i] + b[i] + 1;
            } else {
                tmp = a[i] + b[i];
            }

            // 相加结果大于10，进位标志改为true
            if (tmp >= 10) {
                mark = true;
                tmp -= 10;
            } else {
                mark = false;
            }

            sum[i+1] = tmp;
        }

        // 如果数组第一位是0，则将第一位删除
        if(sum[0] == 0) {
            sum = Arrays.copyOfRange(sum, 1, sum.length);
        }

        return sum;
    }
}
