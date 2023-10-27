package com.czff.study.knowledge.juc.threadpool;

import java.util.concurrent.*;

/**
 * @author cuidi
 * @date 2021/7/21 13:39
 * @description 线程池创建线程
 */
public class ThreadPoolCustom  {
    /**
     * Proceed in 3 steps:
     * <p>
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     * <p>
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     * <p>
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
     */
    public static void main(String[] args) throws InterruptedException {
        treadPoolPersonal();
        //treadPoolCase();
    }

    private static void treadPoolPersonal() throws InterruptedException {
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ThreadPoolExecutor tr = new ThreadPoolExecutor(
                2,
                5,
                1L,
                unit,
                workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 8; i++) {
            tr.execute(() -> {
                // ... do something inside runnable task
                System.out.println(Thread.currentThread().getName() + "\t 进行业务处理！");
            });
        }
        TimeUnit.SECONDS.sleep(5L);
        tr.shutdown();
        System.out.println(Thread.currentThread().getName() + "任务结束！");
    }

    private static void treadPoolCase() {
        // 一池5处理线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池1处理线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 一池N处理线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        threadPool.execute(() -> {
            // ... do something inside runnable task
            System.out.println(Thread.currentThread().getName() + "\t 处理业务");
        });
    }
}
