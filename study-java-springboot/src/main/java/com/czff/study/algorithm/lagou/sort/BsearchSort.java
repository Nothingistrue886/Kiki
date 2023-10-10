package com.czff.mydemo.algorithm.lagou.sort;

/**
 * @author 疾风劲草
 * @date 2022/4/26 19:11
 * @description 二分查找针对的是一个有序的数据集合  O(logn) 惊人的查找速度
 */
public class BsearchSort {

    /**
     * 二分查找的循环实现
     */
    public int bsearchLoop(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 二分查找的递归实现
     */
    public int bsearchRecursion(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }
}
