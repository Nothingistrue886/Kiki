package com.czff.study.designmodel.singleton;

/**
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是单例。
 *
 * @author cuidi
 */
public enum SingletonEnum {
    /**
     * 实例
     */
    INSTANCE;

    /**
     * 可以省略此方法，通过Singleton.INSTANCE进行操作
     */
    public static SingletonEnum getInstance() {
        return SingletonEnum.INSTANCE;
    }
}
