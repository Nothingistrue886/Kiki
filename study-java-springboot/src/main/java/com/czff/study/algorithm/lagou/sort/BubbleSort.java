package com.czff.study.algorithm.lagou.sort;

/**
 * @author 疾风劲草
 * @date 2022/4/22 17:51
 * @description 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序，a表示数组，n表示数组大小
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) break;
        }
    }
}
