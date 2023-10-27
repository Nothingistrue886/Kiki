package com.czff.study.knowledge.juc.threadlocal;

/**
 * @author 疾风劲草
 * @date 2022/6/28 22:59
 * @description
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
    public static void main(String[] args) {

        Integer integer = threadLocal.get();
        threadLocal.set(2);
        System.out.println(integer);
    }
}
