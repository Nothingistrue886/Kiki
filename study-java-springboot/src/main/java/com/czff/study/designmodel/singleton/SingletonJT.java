package com.czff.mydemo.designmodel.singleton;


/**
 * 静态内部类：
 * 线程安全，延迟加载，保证实例对象唯一。
 * 外部类加载时不需要立即加载内部类，
 * 只有在第一次调用 getInstance() 方法时，才会加载内部类。
 */

public class SingletonJT {

    private SingletonJT() {
    }

    private static class Inner {
        private static final SingletonJT instance = new SingletonJT();
    }

    public static SingletonJT getInstance() {
        return Inner.instance;
    }
}
