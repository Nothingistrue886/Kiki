package com.czff.mydemo.knowledge.juc.thread.newthread;

import java.util.concurrent.*;

/**
 * @author cuidi
 * @description 多线程
 * 1.继承Thread
 * 2.实现Runnable接口
 * 3.实现Callable接口 + FutureTask（可以拿到返回接口，可以处理异常）
 * 实际业务中以上都不用
 * 4.线程池，异步任务交给线程池执行
 * @date 2023/6/1 10:42
 */
public class ThreadTest {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main线程start...");

        //4.线程池
        //4.4
        Future<Integer> submit = executor.submit(new Callable01());
        System.out.println("返回结果：" + submit.get());
        assert submit.get() == 5;
        executor.shutdown();

        //4.3
//        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
//        executor.submit(futureTask);
//        System.out.println("返回结果：" + futureTask.get());
//        executor.shutdown();

        //4.2
//        FutureTask<String> futureTask = new FutureTask<>(new Runnable01(), "this is result");
//        executor.submit(futureTask);
//        System.out.println("返回结果：" + futureTask.get());
//        executor.shutdown();

        // 4.1
//        FutureTask<Integer> futureTask = new FutureTask<>(new Runnable01(), null);
//        executor.execute(futureTask);
//        executor.shutdown();


        //3.实现Callable接口 + FutureTask
        //3.2
//        FutureTask<String> futureTask = new FutureTask<>(new Runnable01(), "this is result");
//        new Thread(futureTask).start();
//        String result = futureTask.get();
//        System.out.println("result：" + result);

//        3.1
//        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
//        new Thread(futureTask).start();
//        // 等待线程执行完毕，获取返回值。（阻塞等待）
//        Integer integer = futureTask.get();
//        System.out.println("futuretask call back：" + integer);

        //2.实现Runnable接口
//        Runnable01 runnable01 = new Runnable01();
//        Thread thread = new Thread(runnable01);
//        thread.start();


        //1.继承Thread
//        Thread01 t1 = new Thread01();
//        t1.start();

        System.out.println("main线程end...");

    }

    static class Callable01 implements Callable<Integer> {
        // 方法有返回值
        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
            return i;
        }
    }

    static class Runnable01 implements Runnable {
        // 方法无返回值
        @Override
        public void run() {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }

    static class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }
}
