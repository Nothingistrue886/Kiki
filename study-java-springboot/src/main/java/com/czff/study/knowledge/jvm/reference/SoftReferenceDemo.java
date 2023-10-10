package com.czff.mydemo.knowledge.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @author cuidi
 * @date 2021/4/21 17:03
 * @description softReference 内存够用就保留,不够用就回收
 * <p>
 * 场景: 读取大量图片
 * Map<String, SoftReference<BitSet>> imageCache = new HashMap<>();
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        //softRed_Memory_Enough();
        softRed_Memory_NotEnough();


    }

    /**
     * JVM配置: 故意产生大对象并配置小内存,让它导致OOM,看软引用回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
     */
    private static void softRed_Memory_NotEnough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());

        o = null;

        try {
            byte[] bytes = new byte[10 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }

    }

    private static void softRed_Memory_Enough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());
    }
}
