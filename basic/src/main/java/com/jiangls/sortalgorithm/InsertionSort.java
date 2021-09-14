package com.jiangls.sortalgorithm;

import java.util.Arrays;

/**
 * <p>直接插入排序</p>
 * <p>
 *     直接插入排序的基本思想是：将 n 个有序数存放在数组 a 中，要插入的数为 x，首先确定 x 插在数组中的位置 p，
 *     然后将 p 之后的元素都向后移一个位置，空出 a(p)，将 x 放入 a(p)，这样可实现插入 x 后仍然有序。
 * </p>
 * <p>
 *     这种排序方式稍稍有点难以理解，这里的实现是：不断的将数组中小的数前移，最终结果是最小的数移动到最前面
 * </p>
 */
public class InsertionSort {

    public static void main(String[] args) {
        Number[] numbers = { 13, 15, 24, 99, 4, 1 };
        System.out.println("排序前：" + Arrays.toString(numbers));

        insertionSort(numbers);
        System.out.println("排序后：" + Arrays.toString(numbers));
    }

    public static void insertionSort(Number[] numbers) {
        Number temp;
        int j;
        for (int i = 1; i < numbers.length; i++) {
            temp = numbers[i];
            for (j = i - 1; j >= 0 && numbers[j].doubleValue() > temp.doubleValue(); j--) {
                numbers[j + 1] = numbers[j];
            }
            numbers[j + 1] = temp;
        }
    }
}
