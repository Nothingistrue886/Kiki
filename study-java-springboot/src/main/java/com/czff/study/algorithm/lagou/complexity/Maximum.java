package com.czff.study.algorithm.lagou.complexity;


/**
 * @author 疾风劲草
 * @date 2020/6/7 21:26
 * @description 定义了一个数组 a = [1, 4, 3]，查找数组 a 中的最大值
 */
public class Maximum {
    public static void main(String[] args) {
        s1_3();
    }

    /**
     * 时间复杂度为 O(n)
     */
    private static void s1_3() {
        int[] a = {1, 4, 3};
        int max_val = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max_val) {
                max_val = a[i];
            }
        }
        System.out.println(max_val);
    }


}
