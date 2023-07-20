package com.czff.mydemo.thread.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cuidi
 * @description
 * @date 2023/6/2 14:13
 */
public class CompletableFutureTest {

    private static final ExecutorService myThreadPoolExecutor = Executors.newFixedThreadPool(10);

    // main方法中不能自动注入
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main线程start...");


        runAsyncMethod();
//
//        supplyAsyncMethod();
//
//        handleMethod();
//        serialMethod();
//        completeBothTasks();

        System.out.println("main线程end...");
    }


    private static void runAsyncMethod() {
        CompletableFuture.runAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }, myThreadPoolExecutor);
    }

    private static void supplyAsyncMethod() {
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int j = 10 / 2;
            System.out.println("运行结果：" + j);
            return j;
        }, myThreadPoolExecutor);
        try {
            Integer integer = supplyAsync.get();
            System.out.println("返回结果：" + integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // 方法执行完成后的处理
    private static void handleMethod() {
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int z = 10 / 2;
            System.out.println("运行结果：" + z);
            return z;
        }, myThreadPoolExecutor).handle((res, throwable) -> {
            if (res != null) {
                return res * 2;
            }
            return -1;
        });
        try {
            Integer result = supplyAsync.get();
            System.out.println("返回结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程串行化
     * 1.thenRun() / thenRunAsync()         // 上个任务执行完成，就开始执行thenRun，进行后续任务的处理
     * 2.thenAccept() / thenAcceptAsync()   // 消费处理结果。接受任务的处理结果，并消费处理，无返回值
     * 3.thenApply() / thenApplyAsync()     // 当一个线程依赖另一个线程时，获取上一个任务返回的结果，并返回当前任务的返回值
     */
    private static void serialMethod() {
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            System.out.println("当前线程name：" + Thread.currentThread().getName());
            int z = 10 / 2;
            System.out.println("运行结果：" + z);
            return z;
        }, myThreadPoolExecutor).thenApplyAsync(res -> {
            System.out.println("thenApplyAsync：" + res);
            return res;
        }, myThreadPoolExecutor);
        try {
            Integer result = supplyAsync.get();
            System.out.println("返回结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.两个任务都要完成
     * 2.两个任务其中一个完成
     * 3.多任务组合
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void completeBothTasks() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            int z = 10 / 2;
            System.out.println("运行结果：" + z);
            return z;
        }, myThreadPoolExecutor);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程id：" + Thread.currentThread().getId());
            return "hello world";
        }, myThreadPoolExecutor);

        // 不需要获取future的结果，只需要两个future处理完成后，处理该任务
//        future1.runAfterBothAsync(future2, () -> System.out.println("任务组合开始：..."), myThreadPoolExecutor);

        // 接收前面两个任务的返回值，并进行处理，但是没有返回值
//        future1.thenAcceptBothAsync(future2, (f1,f2) -> System.out.println("任务组合开始：... " + f1 + "---" + f2), myThreadPoolExecutor);

        // 获取两个future的返回结果，处理后，返回当前任务的返回值
        CompletableFuture<String> combineAsync = future1.thenCombineAsync(future2, (f1, f2) -> {
            System.out.println("任务组合开始：... " + f1 + "---" + f2);
            return f1.toString() + "---" + f2;
        }, myThreadPoolExecutor);
        System.out.println(combineAsync.get());


    }

}
