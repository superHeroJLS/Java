package com.jiangls.sort;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2023/4/17
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // n个元素，排序次数n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIdx = i;
            // 循环确定minIdx
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }

            // 下标i元素与下标minIdx元素交换
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
            System.out.println(i + "次排序结果：" + Arrays.toString(arr));
        }
    }
}
