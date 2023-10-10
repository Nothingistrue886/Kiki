package com.czff.mydemo.knowledge.juc.thread.interrupted;

import java.util.concurrent.TimeUnit;

/**
 * @author cuidi
 * @date 2022/2/15 10:40
 * @description
 */
public class SleepUtils {
    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignored) {
        }
    }
}