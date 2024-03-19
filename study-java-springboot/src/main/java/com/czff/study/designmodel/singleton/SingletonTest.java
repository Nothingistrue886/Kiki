package com.czff.study.designmodel.singleton;

/**
 * @author cuidi
 * @date 2021/4/21 10:44
 * @description
 */
public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                InstanceFactory instance = InstanceFactory.getInstance();
                System.out.println(Thread.currentThread().getName() + "\t" + instance);
            }, String.valueOf(i)).start();
        }
        //doubleCheckMethod();
    }

    private static void doubleCheckMethod() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                DoubleCheckLock.getInstance();
            }, String.valueOf(i)).start();
        }
    }


}
