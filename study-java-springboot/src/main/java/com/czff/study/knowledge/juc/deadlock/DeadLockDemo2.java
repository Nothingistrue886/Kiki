package com.czff.study.knowledge.juc.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author cuidi
 * @date 2021/7/23 8:48
 * @description 什么是死锁？
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，
 * 若无外力作用，它们都将无法推进下去。
 * 此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。
 */
public class DeadLockDemo2 {

    public static void main(String[] args) {

        new Thread(new Resource("strA", "strB"), "ThreadA").start();
        new Thread(new Resource("strB", "strA"), "ThreadB").start();

    }

    static class Resource implements Runnable {
        private String lockA;
        private String lockB;

        public Resource(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获取：" + lockB);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获取：" + lockA);
                }
            }
        }
    }
}
