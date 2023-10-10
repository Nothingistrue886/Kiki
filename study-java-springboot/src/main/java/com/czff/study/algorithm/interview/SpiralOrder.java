package com.czff.mydemo.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 疾风劲草
 * @date 2022/7/2 18:13
 * @description 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * 例如，
 * 给出以下矩阵：
 * [
 *   [ 1，2，3，4],
 *   [5，6，7，8],
 *   [9，10，11，12],
 *   [13，14，15，16]，
 *   [17，18，19，20]
 * ]
 *
 * 你应该返回[1, 2, 3, 4, 8, 12, 16, 20, 19, 18, 17, 13, 9, 5, 6, 7, 11, 15, 14, 10]。
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        List sort = sort(nums);
        System.out.println(sort);
    }

    private static List<Integer> sort(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;
        while (top < nums.length && left < nums[0].length) {
            // left -> right
            for (int i = left; i <= right; i++) {
                list.add(nums[top][i]);
            }
            // top -> bottom
            for (int i = top + 1; i <= bottom; i++) {
                list.add(nums[i][right]);
            }
            // right -> left
            for (int i = right - 1; top != bottom && i >= left; i--) {
                list.add(nums[bottom][i]);
            }
            // bottom -> top
            for (int i = bottom - 1; i >= top + 1; i--) {
                list.add(nums[i][left]);
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return list;
    }
}
