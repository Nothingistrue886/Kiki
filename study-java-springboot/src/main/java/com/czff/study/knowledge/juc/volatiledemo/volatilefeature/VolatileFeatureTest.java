package com.czff.mydemo.knowledge.juc.volatiledemo.volatilefeature;

/**
 * @author cuidi
 * @date 2021/9/24 15:28
 * @description 详情参考：juc并发编程的艺术中的 volatile 的内存语义
 * 两个方法结果是相同的
 */
public class VolatileFeatureTest {

    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method1() {
        VolatileFeature1 volatileFeature1 = new VolatileFeature1();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                volatileFeature1.getAndIncrement();
                long l = volatileFeature1.get();
                System.out.println("ThreadA：" + Thread.currentThread().getName() + ">>>" + l);
            }, String.valueOf(i)).start();
        }
    }

    private static void method2() {
        VolatileFeature2 volatileFeature2 = new VolatileFeature2();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                volatileFeature2.getAndIncrement();
                long l = volatileFeature2.get();
                System.out.println("ThreadB：" + Thread.currentThread().getName() + ">>>" + l);
            }, String.valueOf(i)).start();
        }
    }
}
