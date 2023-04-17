package com.jiangls.sort;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2023/4/17
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 区间内至少存在2个元素
        if (left < right) {
            // 用区间内第一个元素作为基准
            int base = arr[left];
            int i = left;
            int j = right;
            // 从2端交替从中间扫描，直到i==j
            while (i != j) {
                while(j > i && arr[j] > base) {
                    j--;
                }
                /**
                 * 起始时下表i元素已经保存至base中，故下标i处空闲可以保存下标j的元素；
                 * 执行完下面这行代码后，下标j处元素保存至了下标i处，此时下标j处空闲了。
                 */
                arr[i] = arr[j];
                while (i < j && arr[i] <= base) {
                    i++;
                }
                /**
                 * 代码执行到这里时，下标j处空闲，可用于保存下标i处元素；
                 * 执行完下面这行代码后，下标i处元素保存至了下标j处，此时下标i处空闲了。
                 */
                arr[j] = arr[i];
            }
            // 基准元素放到下标i处

            arr[i] = base;
            // 基准元素已不需要再排序；分别对左、右区间排序递归快速排序
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
