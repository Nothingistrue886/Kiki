package com.czff.study.knowledge.juc.deadlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuidi
 * @date 2021/5/19 12:43
 * @description 演示串行和并发执行并累加操作的时间, 并发执行一定比串行执行快吗？
 */
public class ConcurrencyTest {
    private static final long count = 10000000000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        AtomicInteger a = new AtomicInteger();
        Thread thread = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                a.addAndGet(5);
                //System.out.println(Thread.currentThread().getName() + " ==== a=" + a);
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        // 是主线程等待子线程的终止
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b + ",a=" + a);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
