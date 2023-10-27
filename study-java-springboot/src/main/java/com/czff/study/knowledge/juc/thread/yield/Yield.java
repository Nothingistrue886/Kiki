package com.czff.study.knowledge.juc.thread.yield;

/**
 * @author cuidi
 * @date 2022/2/15 16:19
 * @description yield() 线程让步。顾名思义，就是说当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行。
 */
public class Yield {
    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "thread1");
        Thread thread2 = new Thread(runnable2, "thread2");
        thread1.start();
        thread2.start();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                if ("thread1".equals(name)) {
                    Thread.yield();
                }
                System.out.println(name + " ::: " + i);
            }
        }
    }
}


