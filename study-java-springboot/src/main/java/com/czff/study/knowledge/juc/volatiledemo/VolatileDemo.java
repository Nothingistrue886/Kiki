package com.czff.mydemo.knowledge.juc.volatiledemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuidi
 * @date 2021/4/20 10:00
 * @description 验证volatile的保证可见性、不保证原子性、禁止重排序
 * Unsafe 类中的 CAS（Compare-And-Swap） 是一条 CPU 的 原子指令（cmpxchg 指令），不会造成所谓的数据不一致问题
 */
public class VolatileDemo {

    int number = 0;

    // 实现 count++ 原子操作的其他类 AtomicInteger、 LongAdder
    // JDK1.8 推荐使用 LongAdder
    AtomicInteger atomicInteger = new AtomicInteger();

    //LongAdder longAdder = new LongAdder();
    void add() {
        this.number = 60;
    }

    void addPlusPlus() {
        // i++ 不是原子操作（ILOAD、IINC、ISTORE）
        number++;
    }

    void addAtomic() {
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        // 可见性
        //visibilityOfVolatile();
        // 不保证原子性
        atomicOfVolatile();
    }

    private static void atomicOfVolatile() {
        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    volatileDemo.addPlusPlus();
                    volatileDemo.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 有 mian 主线和 GC 线程,因此 > 2
        while (Thread.activeCount() > 2) {
            // 主线程让步
            // Thread.yield() 方法,使当前线程由执行状态,变成为就绪状态,让出cpu时间,在下一个线程执行时候,此线程有可能被执行,也有可能没有被执行。
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "  the number value: " + volatileDemo.number);
        System.out.println(Thread.currentThread().getName() + "  the atomicInteger value: " + volatileDemo.atomicInteger);
    }

    private static void visibilityOfVolatile() {
        VolatileDemo volatileDemo = new VolatileDemo();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " init number value: " + volatileDemo.number);
            try {
                // Thread.sleep(3000);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileDemo.add();
            System.out.println(Thread.currentThread().getName() + " updated number value: " + volatileDemo.number);
        }, "thread 1").start();

        // 线程池创建
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(2);
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                queue, r -> {
            Thread thread = new Thread(null, r, "threadPoolFirst", 0);
            System.out.println(thread.getName());
            return thread;
        });
        threadPoolFirst.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " init number value: " + volatileDemo.number);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileDemo.add();
            System.out.println(Thread.currentThread().getName() + " updated number value: " + volatileDemo.number);
        });

        while (volatileDemo.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + " number value: " + volatileDemo.number);
    }
}
