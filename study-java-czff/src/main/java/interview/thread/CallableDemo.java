package interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 疾风劲草
 * @date 2021/7/20 20:22
 * @description 实现多线程Callable interface
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask task = new FutureTask<>(myThread);
        new Thread(task, "AA").start();

        while (!task.isDone()) {

        }
        // 要求取得Callable线程的结果,如果为计算完成,可能会导致阻塞,直到计算完成
        Integer ret = (Integer) task.get();
        System.out.println("return = " + ret);
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}