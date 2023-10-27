package com.czff.study.algorithm.interview.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cuidi
 * @date 2021/7/27 18:44
 * @description abcbcad 输出字符串首个不重复字符的下标
 */
public class FindCharacterIndex {

    public static void main(String[] args) {
        String str = "abcbcad";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.forEach((k, v) -> {
            System.out.println(k + ":::" + v);
        });
        Character key = null;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (1 == value) {
                key = next.getKey();
            }
        }
        int i = str.indexOf(key);
        System.out.println(i);

    }
}
