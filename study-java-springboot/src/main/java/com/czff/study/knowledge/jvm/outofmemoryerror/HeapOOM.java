package com.czff.study.knowledge.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 疾风劲草
 * @date 2022/5/13 11:05
 * @description 堆内存溢出
 * vm args: -Xmx10m -Xms10m -XX:+PrintGCDetails
 * java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {

        ArrayList<HeapOOM> oomArrayList = new ArrayList<>();

        while (true) {
            oomArrayList.add(new HeapOOM());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
