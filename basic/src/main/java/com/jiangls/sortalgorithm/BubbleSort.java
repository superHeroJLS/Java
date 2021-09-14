package com.jiangls.sortalgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>冒泡排序，常用的数组排序算法之一</p>
 * <p>
 *     冒泡排序的基本思想是：对比相邻的元素值，如果满足条件就交换元素值，把较小的元素值移动到数组前面，
 *     把大的元素值移动到数组后面（也就是交换两个元素的位置），这样数组元素就像气泡一样从底部上升到顶部。
 * </p>
 * <p>
 *     冒泡排序的算法比较简单，排序的结果稳定，但时间效率不太高。
 *     Java 中的冒泡排序在双层循环中实现，其中外层循环控制排序轮数，总循环次数为要排序数组的长度减 1。
 *     而内层循环主要用于对比相邻元素的大小，以确定是否交换位置，对比和交换次数依排序轮数而减少。
 * </p>
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number[] scores = new Number[5];
        for(int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + i + "个成绩：");
            scores[i] = scanner.nextDouble();
        }

        System.out.println("排序前的元素值：");
        System.out.println(Arrays.toString(scores));

        bubbleSort(scores);
        System.out.println("排序后的元素值：");
        System.out.println(Arrays.toString(scores));


    }

    /**
     * 冒泡排序
     *
     * @param scores
     * @return
     */
    public static void bubbleSort(Number[] scores) {
        System.out.println("冒泡排序开始：");

        for (int i = 0; i < scores.length - 1; i ++) {
            for (int j = 0; j < scores.length - i -1; j++) {
                if (scores[j].doubleValue() > scores[j+1].doubleValue()) {
                    Number temp = scores[j+1];
                    scores[j+1] = scores[j];
                    scores[j] = temp;
                }
            }
        }
    }
}
