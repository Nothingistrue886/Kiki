package interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 疾风劲草
 * @date 2021/7/17 9:01
 * @description 线程通信之生产消费阻塞队列 volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(2));

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 生产线程开启: ");
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 消费线程开启: ");
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "\t 线程结束!");
        myResource.stop();
    }


    static class MyResource {

        /**
         * 默认开启,进行生产+消费
         */
        private volatile boolean FLAG = true;
        private AtomicInteger atomicInteger = new AtomicInteger();

        private BlockingQueue<String> blockingQueue;

        MyResource(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            System.out.println(blockingQueue.getClass().getSimpleName());
        }

        void myProd() throws InterruptedException {

            String data;
            boolean retValue;
            while (FLAG) {
                data = atomicInteger.incrementAndGet() + "";
                retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (retValue) {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "\t 生产停止,FLAG=" + FLAG);
        }

        void myConsumer() throws InterruptedException {

            String result;
            while (FLAG) {
                result = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (result == null || "".equals(result)) {
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName() + "\t 消费停止");
                    return;
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
            }
        }

        void stop() {
            FLAG = false;
        }
    }
}

