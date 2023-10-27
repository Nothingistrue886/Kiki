package com.czff.study.designmodel.singleton;

/**
 * @author cuidi
 * @date 2021/4/21 10:39
 * @description 基于volatile的解决方案，实现线程安全的延迟初始化
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock instance = null;

    private DoubleCheckLock() {
        System.out.println("DoubleCheckLock");
    }

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
