package com.czff.study.algorithm.interview;

/**
 * @author 疾风劲草
 * @date 2022/6/29 16:30
 * @description 跳跃游戏Ⅰ
 * https://leetcode.cn/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 */
public class CanJump1 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 1, 4};
       // System.out.println(test1(nums));
        System.out.println(test2(nums));
    }

    private static boolean test1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param nums
     * @return
     */
    private static boolean test2(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPos) return false;
            // 第i个元素能够跳到的最远距离,更新最远距离
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return true;
    }
}

