package com.czff.mydemo.knowledge.reflect;

/**
 * @author cuidi
 * @date 2021/4/23 17:00
 * @description 堆栈获取栈帧中的方法名字
 */
public class AcquireStackName {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("Hello world!");
        if (true) {
            a();
        } else {
            b();
        }

    }

    public static void a() {
        System.out.println("this is a");
        c();
    }

    public static void b() {
        System.out.println("this is b");
        c();
    }

    private static void c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = stackTrace.length - 1; i > 0; i--) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String methodName = stackTraceElement.getMethodName();
            if ("b".equals(methodName)) {
                System.out.println(methodName);
                break;
            } else if ("a".equals(methodName)) {
                System.out.println(methodName);
                break;
            }
        }
        System.out.println("this is c");
    }
}
