package com.czff.study.knowledge.jvm.gc;

/**
 * @author 疾风劲草
 * @date 2021/7/22 20:57
 * @description
 * case: -Xms128m -Xmx4096m -Xss1024k -XX:MetaSpaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 */
public class HelloGc {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------HelloGc");

//        Thread.sleep(Integer.MAX_VALUE);

        // 返回java虚拟机中的内存总量(物理内存的1/64)
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回java虚拟机试图使用的最内存量(物理内存的1/4)
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
    }
}
