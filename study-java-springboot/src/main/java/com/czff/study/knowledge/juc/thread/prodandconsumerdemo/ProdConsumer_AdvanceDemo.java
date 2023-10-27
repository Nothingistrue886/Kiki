package com.czff.study.knowledge.juc.thread.prodandconsumerdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuidi
 * @date 2021/7/16 16:12
 * @description
 */
public class ProdConsumer_AdvanceDemo {
    public static void main(String[] args) {

        ShareData shareData = new ShareData();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                shareData.increment();
            }, "thread1").start();
            new Thread(() -> {
                shareData.decrement();
            }, "thread2").start();
        }
    }
}


class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t 当前线程完成 加操作，值为：" + num);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t 当前线程完成 减操作，值为：" + num);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}