package com.czff.study.knowledge.juc.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cuidi
 * @date 2021/4/17 15:49
 * @description 拒绝策略
 */
public class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected. " + executor.toString());
    }
}
