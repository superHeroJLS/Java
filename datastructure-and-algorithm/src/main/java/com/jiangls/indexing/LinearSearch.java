package com.jiangls.indexing;

/**
 * 顺序查找
 * @author Jiangls
 * @date 2023/4/23
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int idx = linearSearch(arr, 9);
        System.out.println("idx: " + idx);
    }

    /**
     * 顺序查找，找到返回下标，否则返回-1
     * @param arr
     * @param key
     * @return
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + "次比较");
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
