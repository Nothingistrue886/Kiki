package com.czff.study.knowledge.juc.countdownlatchandsemaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author cuidi
 * @date 2021/4/15 13:48
 * @description
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        TranslateThread translateThread1 = new TranslateThread("1st content", countDownLatch);
        TranslateThread translateThread2 = new TranslateThread("2st content", countDownLatch);
        TranslateThread translateThread3 = new TranslateThread("3st content", countDownLatch);
        translateThread1.start();
        translateThread2.start();
        translateThread3.start();
        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完成");

    }
}
