package com.czff.mydemo.knowledge.juc.thread.prodandconsumerdemo;

/**
 * @author cuidi
 * @date 2021/7/16 15:31
 * @description 一个初始值为0的变量，两个线程交替执行加减操作，循环五次
 * 1. 线程->操作->资源类
 * 2. 判断->干活->通知
 */

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                resource.increment();
            }, "thread1").start();

            new Thread(() -> {
                resource.decrement();
            }, "thread2").start();
        }
    }

}

/**
 * 资源类
 */
class ShareResource {

    private int num = 0;

    public synchronized void increment() {
        try {
            while (num != 0) {
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t 当前线程完成 加操作，值为：" + num);
            this.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void decrement() {
        try {
            while (num == 0) {
                this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t 当前线程完成 减操作，值为：" + num);
            this.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
