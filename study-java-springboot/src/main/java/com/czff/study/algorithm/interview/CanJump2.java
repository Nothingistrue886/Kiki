package com.czff.study.algorithm.interview;

/**
 * @author 疾风劲草
 * @date 2022/6/30 11:54
 * @description 跳跃游戏Ⅱ
 * https://leetcode.cn/problems/jump-game-ii/
 * 这道题是典型的贪心算法，通过局部最优解得到全局最优解。
 * 以下两种方法都是使用贪心算法实现，只是贪心的策略不同。
 */
public class CanJump2 {

    public static void main(String[] args) {
        int[] arrs = new int[]{2,3,1,2,4,2,3};
        System.out.println(jump2(arrs));
    }

    /**
     * 方法一：反向查找出发位置
     *
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        // 不用访问最后一个位置
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    /**
     * 方法二：正向查找可到达的最大位置
     *
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
