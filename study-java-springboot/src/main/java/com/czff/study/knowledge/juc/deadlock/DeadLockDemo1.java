package com.czff.mydemo.knowledge.juc.deadlock;

/**
 * @author cuidi
 * @date 2021/5/19 16:33
 * @description 死锁
 * 解决死锁:
 * 1.将线程中的sychronized(A)中的对象顺序相同
 * 2.将静态变量A、B引用指向相同的字符串,在字符串常量池只有一份,这里涉及到可重入锁
 * private static String A = "A";
 * private static String B = "A";
 */
public class DeadLockDemo1 {
    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo1().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + A + "\t 尝试获取：" + B);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + B + "\t 尝试获取：" + A);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + A + "\t 尝试获取：" + B);
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + B + "\t 尝试获取：" + A);
                }
            }
        });
        t1.start();
        t2.start();
    }
}