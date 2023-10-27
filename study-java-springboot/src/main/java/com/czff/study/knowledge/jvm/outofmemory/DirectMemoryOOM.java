package com.czff.study.knowledge.jvm.outofmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author 疾风劲草
 * @date 2022/5/13 10:46
 * @description 本地直接内存溢出
 * vm args: -Xmx20m -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        String name = field.getName();
        System.out.println(name);
        Unsafe unsafe = (Unsafe) field.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }
}
