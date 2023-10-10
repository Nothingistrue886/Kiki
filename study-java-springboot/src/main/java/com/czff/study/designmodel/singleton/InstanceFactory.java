package com.czff.mydemo.designmodel.singleton;

/**
 * @author cuidi
 * @date 2021/11/1 13:31
 * @description 基于类初始化的解决方案，JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。
 *              在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static InstanceFactory instance = new InstanceFactory();
    }

    public static InstanceFactory getInstance() {
        return InstanceHolder.instance; // 这里将导致InstanceHolder类被初始化
    }
}
