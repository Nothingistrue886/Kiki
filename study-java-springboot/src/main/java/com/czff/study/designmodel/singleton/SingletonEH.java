package com.czff.study.designmodel.singleton;

/**
 * 单例模式，属于创建类型的一种常用的软件设计模式。
 * 通过单例模式的方法创建的类在当前进程中只有一个实例。
 * <p>
 * 单例模式的要点有三个；
 * 1.是某个类只能有一个实例；
 * 2.是它必须自行创建这个实例；
 * 3.是它必须自行向整个系统提供这个实例。
 * <p>
 * 从具体实现角度来说，就是以下三点：
 * 1.将该类的构造函数私有化；
 * 2.该类定义中含有一个该类的静态私有对象；
 * 3.该类对外提供一个公共的静态函数用于创建或获取它本身的静态私有对象。
 */

/**
 * 饿汉模式：
 * 线程安全，比较常用，但容易产生垃圾。
 * 因为一开始就初始化，避免了线程同步问题。
 */
public class SingletonEH {
    // 私有的静态对象，防止外界引用
    private static SingletonEH instance = new SingletonEH();

    // 构造方法私有化，防止外界实例化此对象
    private SingletonEH() {
    }

    public static SingletonEH getInstance() {                    // 向外界提供获取实例化对象的静态方法
        return instance;
    }
}
