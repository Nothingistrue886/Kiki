package com.czff.mydemo.knowledge.jvm.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author cuidi
 * @date 2021/7/29 10:13
 * @description 只要gc就会被回收
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        //hashmap();
        weakHashmap();
    }

    private static void hashmap() {
        HashMap<Integer, String> map = new HashMap<>(1);
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());

    }

    private static void weakHashmap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>(1);
        // 务必要 new Integer(); 否则使用的是元空间常量池中缓存的整型(-128-127)
        Integer key = new Integer(2);
        String value = "weakhashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
