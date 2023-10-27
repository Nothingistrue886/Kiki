package com.czff.study.algorithm.leetcode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author cuidi
 * @description 有效的括号 （用栈来解决）
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'  的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例  2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例  3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/21 16:33
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
//        Map<Character, Character> map1 = new HashMap<>();
//        map.put(')', '(');
//        map.put('}', '{');
//        map.put(']', '[');
        // java8初始化map
        Map<Character, Character> map2 = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map2.containsKey(c)) {
                if (stack.isEmpty() || !Objects.equals(stack.peek(), map2.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
