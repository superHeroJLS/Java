package com.jiangls.sortalgorithm;

import java.util.Arrays;

/**
 * <p>
 *     选择排序是指每一趟从待排序的数据元素中选出最大（或最小）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 * </p>
 */
public class SelectionSort {

    public static void main(String[] args) {
        Number[] numbers = {13,15,24,99,4,1};
        System.out.println("排序前：" + Arrays.toString(numbers));

        selectionSort(numbers);
        System.out.println("选择排序后：" + Arrays.toString(numbers));
    }

    public static void selectionSort(Number[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = 0;
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j].doubleValue() > numbers[index].doubleValue()) {
                    index = j;// 查找最大值数组下标
                }
            }
            Number tmp = numbers[numbers.length - 1 -i];
            numbers[numbers.length - 1 - i] = numbers[index];
            numbers[index] = tmp;
        }
    }
}
