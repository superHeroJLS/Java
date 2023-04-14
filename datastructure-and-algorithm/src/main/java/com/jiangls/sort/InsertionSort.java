package com.jiangls.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author Jiangls
 * @date 2023/4/13
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        binaryInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            // 当前a[i]元素应该在已经排好序的序列中间
            if (arr[i] < arr[i - 1]) {
                // 找a[i]合适位置，找到小于等于a[i]的第一个元素的位置
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    // 元素依次往后移动
                    arr[j + 1] = arr[j];
                }
                // j就是小于等于a[i]的第一个元素的位置
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 折半插入排序
     * @param arr
     */
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            if (arr[i] < arr[i-1]) {
                int low = 0;
                int high = i - 1;
                int mid;
                /**
                 * 随着不断的循环，最终一定low == high；此时for循环中mid == low == high，且依然满足条件low <= high，执行最后一次循环体比较，
                 * 比较 tmp > arr[mid] 即 tmp > arr[low]，要不下标low + 1，要不下标high -1，最终就是low都会比high大1；
                 * 最终下标low至i-1处开始全部右移一位
                 */
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (tmp > arr[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                // 从下标low至i-1处开始全部右移一位
                for (int j = i - 1; j >= low; j--) {
                    arr[j + 1] = arr[j];
                }
                // tmp放到下标low处
                arr[low] = tmp;
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {

    }
}
