package com.czff.study.designmodel.adapter;

import java.util.concurrent.Callable;

/**
 * @author cuidi
 * @date 2022/4/7 15:19
 * @description
 */
public class Task implements Callable<Long> {
    private long num;
    public Task(long num) {
        this.num = num;
    }

    @Override
    public Long call() {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}
