package com.czff.mydemo.algorithm.leetcode.easy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author cuidi
 * @description 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 提示：
 * -231<= x <= 231- 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/9 14:18
 */
public class NumberOfReplies {

    public static void main(String[] args) {
        int i = 12231;
        // 数学
        check2(i);

        // 效率太低
//        check1(i);
    }

    private static void check2(int i) {
        int cur = 0;
        int num = i;
        while ( num > 0) {
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(cur == i);
    }

    private static void check1(int i) {
        if (i > 0) {
            String str = String.valueOf(i);
            boolean flag = str.equals(StringUtils.reverse(str));
            System.out.println(flag);
        } else {
            System.out.println(false);
        }
    }

}
