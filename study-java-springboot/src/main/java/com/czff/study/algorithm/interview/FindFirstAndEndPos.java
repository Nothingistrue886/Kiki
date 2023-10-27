package com.czff.study.algorithm.interview;

import java.util.Arrays;

/**
 * @author 疾风劲草
 * @date 2022/7/1 15:05
 * @description 给定非递减排序整数数组nums和一个目标值target。找出目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值，返回[-1,-1]; 期望的时间复杂度为O(logn)算法解决。
 * 示例1 - 输入：nums = [5,7,7,8,8,10] target = 7
 * 输出：[1,2]
 * 示例2 - 输入：nums = [5,7,7,8,8,10] target = 9
 * 输出：[-1,-1]
 */
public class FindFirstAndEndPos {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 7;
        if (nums.length == 0) {
            System.out.println(Arrays.toString(new int[]{-1, -1}));
        }
        int firstPos = findFirstPos(nums, target);
        int endPos = findEndPos(nums, target);
        System.out.println(Arrays.toString(new int[]{firstPos, endPos}));
    }

    private static int findFirstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if ((mid > 0 && nums[mid - 1] != target || mid == 0)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findEndPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if ((mid < nums.length - 1 && nums[mid + 1] != target) || mid == nums.length - 1) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
