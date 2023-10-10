package com.czff.mydemo.algorithm.interview;

/**
 * @author 疾风劲草
 * @date 2022/6/30 17:40
 * @description 不同路径Ⅰ
 * https://leetcode.cn/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
 * 动态规划的题目分为两大类，
 * 一种是求最优解类，典型问题是背包问题，
 * 另一种就是计数类，比如这里的统计方案数的问题，它们都存在一定的递推性质。
 * 前者的递推性质还有一个名字，叫做 「最优子结构」 ——即当前问题的最优解取决于子问题的最优解，
 * 后者类似，当前问题的方案数取决于子问题的方案数。
 * 所以在遇到求方案数的问题时，我们可以往动态规划的方向考虑。
 */
public class UniquePaths1 {

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths1(m, n));
    }

    /**
     * 动态规划 f(i,j)=f(i−1,j)+f(i,j−1)
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    /**
     * 数学方法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
