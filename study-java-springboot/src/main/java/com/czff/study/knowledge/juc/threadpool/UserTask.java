package com.czff.mydemo.knowledge.juc.threadpool;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author cuidi
 * @date 2021/4/17 9:49
 * @description 任务执行体
 */
public class UserTask implements Runnable {

    private AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running" + count.getAndIncrement());
    }
}
