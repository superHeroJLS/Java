package com.jiangls.indexing;

/**
 * 二分查找
 * @author Jiangls
 * @date 2023/4/23
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int idx = binarySearch(arr, 9);
        System.out.println("循环二分查找，idx: " + idx);

        idx = binarySearch(arr, 0, (arr.length - 1) / 2, arr.length - 1, 9);
        System.out.println("递归二分查找，idx: " + idx);
    }

    /**
     * 二分查找循环实现，找到返回下标，否则返回-1
     * @param arr 必须为数组，且必须从小到大排序
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            System.out.println("循环二分查找，开始比较，mid=" + mid);
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return -1;
    }

    /**
     * 二分查找递归实现，找到返回下标，否则返回-1
     * @param arr 必须为数组，且必须从小到大排序
     * @param low
     * @param mid
     * @param high
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int low, int mid, int high, int key) {
        if (low <= high) {
            System.out.println("递归二分查找，开始比较，mid=" + mid);
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
            return binarySearch(arr, low, mid, high, key);
        }

        return -1;
    }
}
