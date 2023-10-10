package com.czff.mydemo.knowledge.juc.countdownlatchandsemaphore;

import java.util.concurrent.Semaphore;

/**
 * @author cuidi
 * @date 2021/4/15 14:15
 * @description TODO
 */
public class CountCheckWindow {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) new SecurityCheckThread(i, semaphore).start();

    }
}
