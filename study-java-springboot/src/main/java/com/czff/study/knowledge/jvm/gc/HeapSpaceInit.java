package com.czff.study.knowledge.jvm.gc;

/**
 * @author 疾风劲草
 * @date 2022/5/13 11:40
 * @description 初始内存大小：物理内存大小/64
 *              最大内存大小：物理内存大小/4
 *
 *  查看内存参数 方式一：
 *              jsp
 *              jstat -gc PID
 *              方式二：
 *              -XX:+PrintGCDetails
 */
public class HeapSpaceInit {

    public static void main(String[] args) {

        long initMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("堆内存初始大小：" + initMemory + "M");
        System.out.println("最大堆内存大小：" + maxMemory + "M");

        System.out.println("系统内存大小：" + initMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小：" + maxMemory * 4.0 / 1024 + "G");

        /*try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
