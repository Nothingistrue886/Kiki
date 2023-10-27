package com.czff.study.designmodel.singleton;

/**
 * 懒汉模式：
 * 线程不安全，延迟初始化，严格意义上不是不是单例模式
 * 多线程下会出现不唯一对象，可以在静态方法中加 synchronized 锁
 */
public class SingletonLH {
    // 此处赋值为null，目的是实现延迟加载Lazy Loading
    private static SingletonLH instance = null;

    private SingletonLH() {
    }

    public static SingletonLH getInstance() {
        if (instance == null) {
            instance = new SingletonLH();
        }
        return instance;
    }
}
