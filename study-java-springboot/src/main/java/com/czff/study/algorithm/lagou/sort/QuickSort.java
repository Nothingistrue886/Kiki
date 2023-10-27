package com.czff.study.algorithm.lagou.sort;

/**
 * @author 疾风劲草
 * @date 2022/4/25 12:51
 * @description TODO
 */
public class QuickSort {

    /**
     * 快速排序
     * @param arr 数组
     * @param left 最小下标
     * @param right 最大下标
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = partition(arr, left, right);
        quickSort(arr, left, q - 1);
        quickSort(arr, q + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }
}
