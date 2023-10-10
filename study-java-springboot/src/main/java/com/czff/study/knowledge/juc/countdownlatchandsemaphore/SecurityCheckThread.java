package com.czff.mydemo.knowledge.juc.countdownlatchandsemaphore;

import java.util.concurrent.Semaphore;

/**
 * @author cuidi
 * @date 2021/4/15 14:16
 * @description TODO
 */
public class SecurityCheckThread extends Thread {

    private int seq;
    private Semaphore semaphore;

    public SecurityCheckThread(int seq, Semaphore semaphore) {
        this.seq = seq;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("no." + seq + "乘客,正在检查中...");
            if (seq % 2 == 0) {
                Thread.sleep(1000);
                System.out.println("no." + seq + "乘客,身份可疑,不能出境！");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("no." + seq + "乘客,已完成安检...");
        }

    }
}
