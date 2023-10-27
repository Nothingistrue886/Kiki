package com.czff.study.algorithm.lagou.complexity;

/**
 * @author 疾风劲草
 * @date 2020/6/7 23:09
 * @description 降低时间复杂度案例
 * <p>
 * 假设有任意多张面额为 2 元、3 元、7 元的货币，现要用它们凑出 100 元，求总共有多少种可能性。
 */
public class BuyChicken100 {
    public static void main(String[] args) {

        s2_1();
        s2_2();
    }

    /**
     * 时间复杂度: O(n^3)
     */
    private static void s2_1() {
        int count = 0;
        for (int i = 0; i <= 100 / 2; i++) {
            for (int j = 0; j <= 100 / 3; j++) {
                for (int k = 0; k <= 100 / 7; k++) {
                    if ((i * 2 + j * 3 + k * 7) == 100) {
                        count++;
                    }
                }
            }
        }
        System.out.println("一共有: " + count + "方法");
    }

    /**
     * 将代码中的无效计算、无效存储剔除，降低时间或空间复杂度。
     * 时间复杂度: O(n^2)
     */
    private static void s2_2() {
        int count = 0;
        for (int i = 0; i <= 100 / 2; i++) {
            for (int j = 0; j <= 100 / 3; j++) {
                // 排除负数可能
                int number = 100 - (i * 2 + j * 3);
                if (number == 0) {
                    count++;
                } else if (number > 0 && number % 7 == 0) {
                    count++;
                }
            }
        }
        System.out.println("一共有: " + count + "方法");
    }
}
