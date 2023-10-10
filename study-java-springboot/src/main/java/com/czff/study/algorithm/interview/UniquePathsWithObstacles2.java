package com.czff.mydemo.algorithm.interview;

/**
 * @author 疾风劲草
 * @date 2022/6/30 17:40
 * @description 不同路径Ⅱ
 * https://leetcode.cn/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
 * 动态规划的题目分为两大类，
 * 一种是求最优解类，典型问题是背包问题，
 * 另一种就是计数类，比如这里的统计方案数的问题，它们都存在一定的递推性质。
 * 前者的递推性质还有一个名字，叫做 「最优子结构」 ——即当前问题的最优解取决于子问题的最优解，
 * 后者类似，当前问题的方案数取决于子问题的方案数。
 * 所以在遇到求方案数的问题时，我们可以往动态规划的方向考虑。
 *
 */
public class UniquePathsWithObstacles2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(test1(obstacleGrid));
    }

    public static int test1(int[][] obstacleGrid) {
        // 行数、列数
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

}
