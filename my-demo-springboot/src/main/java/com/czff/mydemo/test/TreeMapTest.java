package com.czff.mydemo.test;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * @author cuidi
 * @description 测试treemap的key是否可以重复
 * @date 2022/10/28 10:52
 */
public class TreeMapTest {

    public static void main(String[] args) {
        String sort = "desc";
        TreeMap<BigDecimal, Integer> map = new TreeMap<>((o1, o2) -> o2.compareTo(o1) == 0 ? -1 : o2.compareTo(o1));
        map.put(new BigDecimal("1"), 1);
        map.put(new BigDecimal("1"), 1);
        map.put(new BigDecimal("2"), 2);
        map.put(new BigDecimal("3"), 3);
        //只保留前面TopN个元素
        if (map.size() > 5) {
            if ("desc".equals(sort)) {
                map.pollLastEntry();
            }
            if ("asc".equals(sort)) {
                map.pollFirstEntry();
            }
        }
        map.forEach((k, v) -> System.out.println(k + "---" + v));
    }
}
