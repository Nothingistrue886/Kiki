package com.czff.mydemo.algorithm.lagou.complexity;

import java.util.Arrays;

/**
 * @author 疾风劲草
 * @date 2020/6/7 20:39
 * @description 复杂度是衡量代码运行效率的重要的度量因素.
 * <p>
 * Reverse order 输入 a=[1,2,3,4,5]，输出 [5,4,3,2,1]
 */

public class ReverseOrder {
    public static void main(String[] args) {
        s1_1();
        s1_2();
    }

    /**
     * 时间复杂度: O(n) + O(n), 也就是 O(n).
     * 空间复杂度: 创建了一个新数组, 所以是 O(n).
     */
    private static void s1_1() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];
        /* 对数组初始化可以省略 */
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }
        System.out.println(Arrays.toString(b));
    }

    /**
     * 时间复杂度: O(n).
     * 空间复杂度: 只创建了一个临时变量, 所以是 O(1).
     */
    private static void s1_2() {
        int[] a = {1, 2, 3, 4, 5};
        int temp;
        for (int i = 0; i < (a.length / 2); i++) {
            temp = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
