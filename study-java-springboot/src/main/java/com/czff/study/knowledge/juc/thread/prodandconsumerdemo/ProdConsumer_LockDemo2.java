package com.czff.study.knowledge.juc.thread.prodandconsumerdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 疾风劲草
 * @date 2023/12/17 22:30
 * @description Condition精准通知与唤醒线程
 * A执行完调用B，B执行完调用C，C执行完调用A
 */
public class ProdConsumer_LockDemo2 {

    public static void main(String[] args) {
        ShareData2 shareData2 = new ShareData2();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printC();
            }
        }, "C").start();
    }

}


class ShareData2 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;         //1是A，2是B，3是C

    public void printA() {
        lock.lock();
        try {
            //判断、执行、通知
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "==>AAA");
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            //判断、执行、通知
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "==>BBB");
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            //判断、执行、通知
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "==>CCC");
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}