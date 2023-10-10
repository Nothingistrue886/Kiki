package com.czff.mydemo.algorithm.lagou.sort;

/**
 * @author 疾风劲草
 * @date 2022/4/23 22:43
 * @description
 */
public class SortTest {

    public static void main(String[] args) {

        int[] a = {1,5,7,3,6,9,3};
        QuickSort sort = new QuickSort();
        sort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
