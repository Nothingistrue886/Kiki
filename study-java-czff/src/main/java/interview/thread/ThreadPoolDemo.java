package interview.thread;

import java.util.concurrent.*;

/**
 * @author 疾风劲草
 * @date 2021/7/20 22:40
 * @description 自定义线程池 ThreadPoolExecutor
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        treadPoolPersonal();
        //treadPoolCase();

    }

    public static void treadPoolPersonal() {

        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                unit,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{
            // ... do something inside runnable task
            System.out.println(Thread.currentThread().getName() + "\t 处理业务");
        });
    }

    private static void treadPoolCase() {
        // 一池5处理线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池1处理线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 一池N处理线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        threadPool.execute(() -> {
            // ... do something inside runnable task
            System.out.println(Thread.currentThread().getName() + "\t 处理业务");
        });
    }

}
