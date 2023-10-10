package com.czff.mydemo.algorithm.leetcode.easy;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuidi
 * @description 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/9 10:30
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        int target = 9;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                int[] index = new int[]{map.get(res), i};
                System.out.println(Arrays.toString(index));
                break;
            }
            map.put(nums[i], i);
        }
    }
}
