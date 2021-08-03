package interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 疾风劲草
 * @date 2021/7/24 10:33
 * @description 死锁
 *              是指两个或两个以上的进程在执行过程中，
 *              由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，
 *              若无外力作用，它们都将无法推进下去。
 *              此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。
 *
 *              解决
 *              1. 以固定的顺序加锁
 *              2. 使用Lock.tryLock()定时锁，超过时限则返回错误信息
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        deadLock();

    }

    private static void deadLock() {
        MyResource myResource1 = new MyResource("A", "B");
        MyResource myResource2 = new MyResource("B", "A");


        Thread thread1 = new Thread(myResource1);
        Thread thread2 = new Thread(myResource2);

        thread1.start();
        thread2.start();
    }

}

/**
 * 资源类
 */
class MyResource implements Runnable{

    private final String LockA;
    private final String LockB;

    MyResource(String lockA, String lockB) {
        this.LockA = lockA;
        this.LockB = lockB;
    }

    @Override
    public void run() {
        synchronized (LockA) {
            System.out.println(Thread.currentThread().getName()+"\t hold: " + LockA + "\t acquire: " + LockB);
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LockB) {
                System.out.println(Thread.currentThread().getName()+"\t hold: " + LockB + "t acquire: " + LockA);
            }
        }
    }
}
