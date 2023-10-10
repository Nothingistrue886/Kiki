package com.czff.mydemo.knowledge.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author cuidi
 * @date 2022/2/18 15:27
 * @description 实现自旋锁
 */
public class SpinLockDemo {

    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t invoke lock……");
        do {
            System.out.println("加锁自我旋转中……");
        } while (!atomicReference.compareAndSet(null, thread));
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t invoke unlock……");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        new Thread(() -> {
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\texecute...");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        }, "ThreadA").start();

        //try{TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();}

        new Thread(() -> {
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\texecute...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        }, "ThreadB").start();

    }


}
