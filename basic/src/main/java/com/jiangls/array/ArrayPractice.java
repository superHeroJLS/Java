package com.jiangls.array;

import java.util.Arrays;

public class ArrayPractice {

	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 测试Arrays.parallelSort()，并行的 sort-merge 排序
	 */
	public static void testParallelSort() {
		char arr[] = {'d', 'c', 'b', 'a'};
//		byte arr[] = {9, 8, 7, 6};
		System.out.println("before: " + Arrays.toString(arr));
		Arrays.parallelSort(arr);
		System.out.println("after: " + Arrays.toString(arr));
	}
	
	public static void testDeepToString() {
		int[][] ns = {
            { 1, 2, 3, 4 },
            { 5, 6, 7},
            { 9, 10, 11, 12 }
        };
        System.out.println(Arrays.deepToString(ns));
	}
}
