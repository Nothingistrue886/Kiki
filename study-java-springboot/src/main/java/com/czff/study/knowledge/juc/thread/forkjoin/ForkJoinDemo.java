package com.czff.study.knowledge.juc.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 疾风劲草
 * @date 2022/5/1 12:08
 * @description
 */

class MyTask extends RecursiveTask<Integer> {

    private static final int VALUE = 10;
    private int begin;
    private int end;
    private int result;

    
    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - begin) <= VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        } else {
            int mid = begin + ((end - begin) >> 1);
            MyTask myTask1 = new MyTask(begin, mid);
            MyTask myTask2 = new MyTask(mid + 1, end);
            myTask1.fork();
            myTask2.fork();
            result = myTask1.join() + myTask2.join();
        }
        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        Integer integer = forkJoinTask.get();
        System.out.println(integer);
        forkJoinPool.shutdown();
    }
}
