package com.czff.mydemo.algorithm.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2021/9/15 20:58
 * @description LRU 最近最少使用
 */
public class LRUCacheDemo<k, v> extends LinkedHashMap<k, v> {

    private int initialCapacity;

    public LRUCacheDemo(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size() > initialCapacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<Integer, String> lruCacheDemo = new LRUCacheDemo<>(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(1, "a");

    }
}
