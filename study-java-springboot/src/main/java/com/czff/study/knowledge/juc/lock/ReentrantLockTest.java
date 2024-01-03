package com.czff.study.knowledge.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 疾风劲草
 * @date 2022/6/2 19:59
 * @description 多线程实现，打印10次ABC, 可以参考com.czff.study.knowledge.juc.thread.prodandconsumerdemo.ProdConsumer_LockDemo2
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    static String threadName = "A";

    static class RunnA implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (!threadName.equals("A")) {
                        conditionA.await();
                    }
                    System.out.println("A");
                    threadName = "B";
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class RunnB implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (!threadName.equals("B")) {
                        conditionB.await();
                    }
                    System.out.println("B");
                    threadName = "C";
                    conditionC.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class RunnC implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (!threadName.equals("C")) {
                        conditionC.await();

                    }
                    System.out.println("C");
                    System.out.println();
                    threadName = "A";
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new RunnA()).start();
        new Thread(new RunnB()).start();
        new Thread(new RunnC()).start();
    }
}
