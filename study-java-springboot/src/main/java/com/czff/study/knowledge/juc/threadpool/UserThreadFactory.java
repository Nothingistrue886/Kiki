package com.czff.mydemo.knowledge.juc.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuidi
 * @date 2021/4/17 9:49
 * @description TODO
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrfix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrfix = "UserThreadFactory‘s " + whatFeatureOfGroup + "-Worker-";
    }


    @Override
    public Thread newThread(Runnable task) {
        String name = namePrfix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}
