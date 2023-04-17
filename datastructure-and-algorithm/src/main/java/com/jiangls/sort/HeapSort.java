package com.jiangls.sort;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2023/4/17
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        // 构建初始大跟堆
        for (int i = arr.length / 2; i >= 1; i--) {
            sift(arr, i, arr.length);
        }
        System.out.println("大根堆:" + Arrays.toString(arr));

        // 完成堆排序，arr.lenght - 1次就可完成；初始值编号从arr.length开始，编号的值始终比索引大1
        for (int i = arr.length; i > 1; i--) {
            // arr[i - 1] <-> arr[0]交换
            int tmp = arr[i - 1];
            arr[i - 1] = arr[0];
            arr[0] = tmp;
            System.out.println((arr.length - i + 1) + "次排序结果：" + Arrays.toString(arr));
            sift(arr, 1, i - 1);
        }

    }


    /**
     * 筛选算法，构造大根堆
     * @param arr 数组
     * @param low 最小编号，这里最小编号和索引lowIdx关系：low = lowIdx +1，这是因为数组索引从0开始，大跟堆编号从1开始
     * @param high 最大编号，这里最打编号和索引highIdx关系：high = highIdx +1，这是因为数组索引从0开始，大跟堆编号从1开始
     */
    public static void sift(int[] arr, int low, int high) {
        // 定义父子节点编号
        int parent = low;
        int children = 2 * parent;
        // 父节点编号元素，父节点索引=父节点编号-1
        int tmp = arr[low - 1];

        while (children <= high) {
            // children指向元素更大的节点
            if (children < high && arr[children + 1 - 1] > arr[children - 1]) {
                children++;
            }
            // 父节点比子节点小，父节点位置赋予子节点值
            if (tmp  < arr[children - 1]) {
                arr[parent - 1] = arr[children - 1];
                // 修改parent、children以便继续向下筛选
                parent = children;
                children = 2 * parent;
            } else {
                // 父节点大，不再向下调整
                break;
            }
        }

        // 父节点下沉
        arr[parent - 1] = tmp;
    }
}
