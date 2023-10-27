package com.czff.study.algorithm.lagou.sort;

import java.util.Arrays;

public class QuickSort4 {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 4, 3, 9, 5, 1, 12};
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------------");
        quickSort(array, 0, array.length - 1);
        System.out.println("--------------------------");
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {

        int l = low;
        int h = high;

        int key = array[low];// 默认选择第0个为基数

        while (l != h) {// l跟h相等则结束
            while (l < h && array[h] >= key)// h从右向左移动,直到找到一个比基数小的值
                h--;
            if (l < h)
                swap(array, l, h);
            while (l < h && array[l] <= key)// l从左向右移动,直到找到一个比基数大的值
                l++;
            if (l < h)
                swap(array, l, h);
        }

        // 然后把数组从基数所在的位置分成两部分,分别递归
        if (l > low)
            quickSort(array, low, l - 1);
        if (h < high)
            quickSort(array, h + 1, high);

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        System.out.println("交换下标为" + a + "和" + b + "的两个元素");
        System.out.println(Arrays.toString(array));
    }
}
