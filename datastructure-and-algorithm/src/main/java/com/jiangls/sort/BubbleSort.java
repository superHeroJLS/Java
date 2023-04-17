package com.jiangls.sort;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2023/4/17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1  - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
