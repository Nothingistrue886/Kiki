package com.czff.study.algorithm.interview.string;

import java.util.HashMap;

/**
 * @author cuidi
 * @date 2021/3/25 14:18
 * @description 面试题 字符串中字符重复的个数
 */
public class CountNumberOfStirngs {
    public static void main(String[] args) {
        countTheNumberOfStringCharacters();
    }

    private static void countTheNumberOfStringCharacters() {
        String str = "122333446563243254gfddhgfdvgdf";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        hashMap.forEach((k, v) -> System.out.println(k + ":::" + v));
    }
}
