package com.czff.study.knowledge.juc.thread.join;

import lombok.SneakyThrows;

/**
 * @author cuidi
 * @date 2022/2/15 16:19
 * @description join()方法主要作用是同步，
 * 它可以使得线程之间的并行执行变为串行执行。在A线程中调用了B线程的join()方法时，表示只有当B线程执行完毕时，A线程才能继续执行。
 * <p>
 * 实现原理：
 * join方法的原理就是调用相应线程的wait方法进行等待操作的，
 * 例如A线程中调用了B线程的join方法，则相当于在A线程中调用了B线程的wait方法，
 * 当B线程执行完（或者到达等待时间），B线程会自动调用自身的notifyAll方法唤醒A线程，从而达到同步的目的。
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "thread1");
        Thread thread2 = new Thread(runnable2, "thread2");
        thread1.start();
        //thread1.join();
        thread2.start();

    }

    static class MyRunnable implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                if (name.equals("thread1")) {
                    Thread.yield();
                }
                System.out.println(name + " ::: " + i);
            }
        }
    }
}

