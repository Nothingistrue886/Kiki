package com.czff.study.knowledge.juc.countdownlatchandsemaphore;

import java.util.concurrent.CountDownLatch;

/**
 * @author cuidi
 * @date 2021/4/15 13:48
 * @description
 */
public class TranslateThread extends Thread {

    private String content;
    private final CountDownLatch countDownLatch;


    public TranslateThread(String context, CountDownLatch countDownLatch) {
        this.content = context;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符");
        }
        System.out.println(content + "的翻译已完成，译文是...");
        countDownLatch.countDown();
    }
}
