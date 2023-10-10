package com.czff.mydemo.designmodel.singleton;

public class SingletonLock {
    /**
     * volatile关键字
     * 1. 可见性
     * 2. 禁止重排序
     * 3. 不保证原子性
     */
    /**
     *  采用双锁机制，线程安全且在多线程情况下能保持高性能。
     */
    private static volatile SingletonLock instance = null;

    private SingletonLock() {

    }

    public static SingletonLock getInstance() {
        // 先判断实例对象是否存在，不存在则进入同步锁创建
        if (instance == null) {
            /*
             * 多线程下只有一个线程可以进入同步锁，实例化代码只用执行一次，
             * 后面再次访问时，判断第一个if (singleton == null)，直接return实例化对象。
             */
            synchronized (SingletonLock.class) {
                if (instance == null) {
                    /*
                     * 对象的创建在JVM中可能会进行重排序，在多线程访问下存在风险，
                     * 使用volatile修饰instance实例变量
                     */
                    instance = new SingletonLock();
                }
            }
        }
        return instance;
    }
}
