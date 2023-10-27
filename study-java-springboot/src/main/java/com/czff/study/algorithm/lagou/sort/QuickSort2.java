package com.czff.study.algorithm.lagou.sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 4, 3, 9, 5, 1, 12};
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------------");
        quickSort(array, 0, array.length - 1);
        System.out.println("--------------------------");
        System.out.println(Arrays.toString(array));
    }


    /**
     * 快速排序算法
     */
    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int key = partition(list, left, right);

            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, key - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, key + 1, right);
        }

    }

    /**
     * 分割数组，找到分割点
     */
    public static int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int base = list[left];
        while (left < right) {
            while (left < right && list[right] >= base) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= base) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    public static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}
