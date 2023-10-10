package com.czff.mydemo.algorithm.interview;

/**
 * @author 疾风劲草
 * @date 2022/6/15 15:41
 * @description 寻找峰值
 *
 * https://leetcode.cn/problems/find-peak-element/
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,5,6,4};

        // 这种情况不适合二分查找
        //int[] arr = new int[]{-3, 12, 9, 15, 6, 8};
        int bsearchLoop = bsearchLoop(arr);
        System.out.println(bsearchLoop);

        //findPeakElement(arr);
    }

    public static int bsearchLoop(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void findPeakElement(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        System.out.println(index);
    }

}
