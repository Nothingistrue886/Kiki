package com.czff.study.knowledge.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 疾风劲草
 * @date 2021/8/12 19:18
 * @description 银行办理业务模拟AQS（AbstractQueuedSynchronizer）如何进行线程的管理和通知机制
 *  1. lock()
 *  2. acquire()
 *  3. tryAcquire(arg)
 *  4. acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
 */
public class AQSDemo {
    public static void main(String[] args) {

        // 可重入锁
        ReentrantLock lock = new ReentrantLock(true);

        // 3个线程来模拟3来银行办理业务的顾客
        // 第一位顾客A直接去窗口办理业务
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("ThreadA---come in");
                // 暂停几秒钟线程
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "ThreadA").start();

        // 第二位顾客B由于业务窗口只有一个(一个线程)，只能等待
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("ThreadB---come in");
            } finally {
                lock.unlock();
            }
        }, "ThreadB").start();

        // 第三位顾客C由于业务窗口只有一个，只能等待A完成后，与B进行争抢
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("ThreadC---come in");
            } finally {
                lock.unlock();
            }
        }, "ThreadC").start();
    }
}
