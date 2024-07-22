package com.czff.study.knowledge.jvm.outofmemoryerror;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author 疾风劲草
 * @date 2022/5/13 10:46
 * @description 本地直接内存溢出
 * vm args: -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
 * java.lang.OutOfMemoryError: Cannot reserve 10485760 bytes of direct buffer memory (allocated: 8192, limit: 10485760)
 */
public class DirectMemoryOOM {
    private static final int _6MB = 1024 * 1024 * 6;
    public static void main(String[] args) throws InterruptedException {
        // Getting max direct memory
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long maxDirectMemory = heapMemoryUsage.getMax();
        System.out.println("配置的maxDirectMemory: " + (maxDirectMemory / (double) 1024 / 1024) + "MB");
        TimeUnit.SECONDS.sleep(3);
        ByteBuffer.allocateDirect(_6MB);
    }
}