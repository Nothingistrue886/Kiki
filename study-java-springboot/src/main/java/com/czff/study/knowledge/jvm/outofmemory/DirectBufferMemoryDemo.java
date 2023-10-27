package com.czff.study.knowledge.jvm.outofmemory;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author 疾风劲草
 * @date 2021/7/26 21:09
 * @description 配置参数: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * 故障现象: Exception in thread "mian" java.lang.OutOfMemoryError: Direct buffer memory
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("配置的maxDirectMemory: " + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");

        TimeUnit.SECONDS.sleep(3);

        //byte[] bytes = new byte[6 * 1024 * 1024];
        
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
