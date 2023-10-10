package com.czff.mydemo.algorithm.interview.recurrence;

/**
 * @author cuidi 递归
 * @description
 * @date 2023/3/2 16:59
 */
public class Recurrence {

    public static void main(String[] args) {
//        int f = f(6);
//        System.out.println(f);
        int n = 1234;
        f2(n);
    }

    public static int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void  f2(int n) {
        int i = n % 10;
        n = n / 10;
        System.out.print(i);
        if (n > 10) {
            f2(n);
        } else {
            System.out.print(n);
        }
    }
}
