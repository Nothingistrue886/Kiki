package com.czff.mydemo.designmodel.adapter;

import java.util.concurrent.Callable;

/**
 * @author cuidi
 * @date 2022/4/7 15:23
 * @description
 * 编写一个Adapter的步骤如下：
 *
 * 实现目标接口，这里是Runnable；
 * 内部持有一个待转换接口的引用，这里是通过字段持有Callable接口；
 * 在目标接口的实现方法内部，调用待转换接口的方法。
 *
 * 这样一来，Thread就可以接收这个RunnableAdapter，因为它实现了Runnable接口。
 * Thread作为调用方，它会调用RunnableAdapter的run()方法，在这个run()方法内部，又调用了Callable的call()方法，
 * 相当于Thread通过一层转换，间接调用了Callable的call()方法。
 */
public class RunnableAdapter implements Runnable {

    /**
     * 引用待转换接口
     */
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            System.out.println("before Adapter...");
            callable.call();
            System.out.println("after Adapter...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
