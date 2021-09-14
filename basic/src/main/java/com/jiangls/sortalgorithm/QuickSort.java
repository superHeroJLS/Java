package com.jiangls.sortalgorithm;

import java.util.Arrays;

/**
 * <p>快速排序，快速排序（Quicksort）是对冒泡排序的一种改进，是一种排序执行效率很高的排序算法。</p>
 * <p>
 *     快速排序的基本思想是：通过一趟排序，将要排序的数据分隔成独立的两部分，其中一部分的所有数据比另外一部分的所有数据都要小，
 *     然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此使整个数据变成有序序列。
 * </p>
 * <p>
 *     具体做法是：假设要对某个数组进行排序，首先需要任意选取一个数据（通常选用第一个数据）作为关键数据，然后将所有比它小的数都放到它的前面，所有比它大的数都放到它的后面。这个过程称为一趟快速排序；递归调用此过程，即可实现数据的快速排序。
 * </p>
 */
public class QuickSort {
    public static void main(String[] args) {
        Number[] numbers = {13,15,24,99,14,11,1,2,3};
        System.out.println("排序前：" + Arrays.toString(numbers));

        quickSort(numbers);
        System.out.println("快速排序后：" + Arrays.toString(numbers));
    }

    public static void quickSort(Number[] numbers) {
        if (numbers.length > 0) {
            recusiveSort(numbers, 0, numbers.length - 1);
        }
    }

    public static void recusiveSort(Number[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);// 将list数组一分为二
            recusiveSort(numbers, low, middle -1 );// 对低字表进行递归排序
            recusiveSort(numbers, middle + 1, high);// 对高字表进行递归排序
        }
    }

    public static int getMiddle(Number[] numbers, int low, int high) {
        Number tmp = numbers[low];// 数组的第一个值作为中轴（分界点或关键数据）
        while (low < high) {
            while (low < high && numbers[high].doubleValue() > tmp.doubleValue()) {
                high--;
            }
            numbers[low] = numbers[high];// 比中轴小的记录移到低端
            while (low < high && numbers[low].doubleValue() < tmp.doubleValue()) {
                low++;
            }
            numbers[high] = numbers[low];// 比中轴大的记录移到高端
        }
        numbers[low] = tmp;// 中轴记录到尾
        return low;// 中轴记录到尾
    }

}
