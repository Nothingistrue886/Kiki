package com.czff.study.knowledge.jvm.outofmemoryerror;

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

        // 返回java虚拟机中的内存总量(物理内存的1/64)
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回java虚拟机试图使用的最内存量(物理内存的1/4)
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
    }
}
