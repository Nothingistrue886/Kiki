package com.czff.study.algorithm.lagou.sort;

/**
 * @author 疾风劲草
 * @date 2022/6/2 21:31
 * @description 1000个有序数组，数组内元素不唯一，取出所有数组元素中最大的10个数
 */
public class RandomArray {

    public static void main(String[] args) {

        int[] arrayW = new int[10000];
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            // 小数组
            int random2 = (int) (Math.random() * 10 + 1);
            int[] innerArray = new int[random2];
            for (int j = 0; j < innerArray.length; j++) {
                innerArray[j] = random2 * j;
               // System.out.print(innerArray[j] + " ");
                arrayW[count] = innerArray[j];
                count++;
            }
            //System.out.println();
        }
        // 快速排序
        System.out.println(count);
        QuickSort sort = new QuickSort();
        sort.quickSort(arrayW, 0, count - 1);
        for (int i = 0; i < count; i++) {
            //System.out.println(arrayW[i]);
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println(arrayW[--count]);
        }
    }
}
