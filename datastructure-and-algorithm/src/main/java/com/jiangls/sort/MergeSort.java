package com.jiangls.sort;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2023/4/17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};

//        mergeSortUptoDn(arr, 0, arr.length - 1);
        mergeSortDnToUp(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序，自顶向下归并排序
     * @param arr
     * @param low 最小下标
     * @param high 最大下标
     */
    public static void mergeSortUptoDn(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            /**
             * 继续分解，分解这里有2个特殊边界情况：
             * 1 对2个元素进行分解即low + 1 == high，此时mid == low，mid + 1 == high，2次递归mergeSort时不会执行任何操作，
             * 直接执行方法merge进行合并且排序low--high。
             * 2 对3个元素进行分解即low + 2 == high，此时mid == (low + high) / 2 == low + 1，这时执行mergeSort(arr,low,mid)
             * 就是第1种特殊情况即下标low--mid之间的元素合并且排好序；mid + 1 == high，这时执行mergerSort(arr,mid+1,high)
             * 不会执行任何操作；直接执行方法merge进行合并且排序low--high。
             */
            System.out.println("分解结果，low-mid-high：" + low + "-" + mid + "-" + high);
            mergeSortUptoDn(arr, low, mid);
            mergeSortUptoDn(arr, mid + 1, high);

            // 合并且排序
            merge(arr, low, high, mid);
        }
    }

    public static void merge(int[] arr, int low, int high, int mid) {
        // 临时数组，存储已排序元素，长度为下标low--high的长度
        int[] tmpArr = new int[arr.length];

        // l左边数组起始下标，r右边数组起始下标，p临时数组起始下标
        int l = low, r = mid + 1, p = low;

        // 将左边数组和右边数组排序且存放至临时数组中
        while(l <= mid && r <= high) {
            if (arr[l] < arr[r]) {
                tmpArr[p] = arr[l];
                l++;
            } else {
                tmpArr[p] = arr[r];
                r++;
            }
            p++;
        }

        // 将左边数组剩余的元素存放至临时数组中或者将右边数组剩余元素存放至临时数组中
        if (l <= mid) {
            while (l <= mid) {
                tmpArr[p] = arr[l];
                p++;
                l++;
            }
        } else if (r <= high) {
            while (r <= high) {
                tmpArr[p] = arr[r];
                p++;
                r++;
            }
        }

        // 将临时数组中low--high元素复制到原数组中
        for (int i = low; i <= high; i++) {
           arr[i] = tmpArr[i];
        }

        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    /**
     * 归并排序，自底向上
     * @param arr
     */
    public static void mergeSortDnToUp(int[] arr) {
        // len待合并的子数组长度
        for (int len = 1; len < arr.length; len = len * 2) {
            int i = 0;
            // 合并长度len相邻2个子数组，合并后子数组长度为2 * len，所以需要合并的时候下标low = i，high = i + 2*len -1
            for (i = 0; i + 2 * len - 1 <= arr.length - 1; i = i + 2 * len) {
                merge(arr, i, i + 2 * len -1, i + len - 1);
            }

            // 合并落单的子数组
            if (i + len - 1 <= arr.length - 1) {
                merge(arr, i, arr.length - 1, i + len -1);
            }
        }
    }
}
