package com.czff.study.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author cuidi
 * @description 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例  2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/27 10:35
 */
public class AddOneTenth {

    public static void main(String[] args) {
        int[] digits = {9};
        int[] one = addOne(digits);
        System.out.println(Arrays.toString(one));
    }

    public static int[] addOne(int[] nums) {
        int len = nums.length - 1;
        for (int i = len; i >= 0 ; i--) {
            if (nums[i] == 9) {
                nums[i] = 0;
            } else {
                nums[i]++;
                return nums;
            }
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }
}
