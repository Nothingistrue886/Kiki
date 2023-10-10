package com.czff.mydemo.knowledge.juc.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cuidi
 * @date 2021/4/17 10:12
 * @description 线程池创建线程
 * 当任务被拒绝的时候，拒绝策略会打印出当前线程池的大小，执行线程，队列大小，完成的任务数
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 缓存队列设置固定长度为2，为了快速触发rejectHandler
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(2);

        UserThreadFactory factory1 = new UserThreadFactory("myThread1");
        UserThreadFactory factory2 = new UserThreadFactory("myThread2");

        UserRejectHandler handler = new UserRejectHandler();

        // 核心线程为1，最大线程为2，为了保证触发rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, factory1, handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, factory2, handler);

        Runnable task = new UserTask();
        for (int i = 0; i < 10; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}

