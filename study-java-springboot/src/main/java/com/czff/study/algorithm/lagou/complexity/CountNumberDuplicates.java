package com.czff.mydemo.algorithm.lagou.complexity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2020/6/7 21:31
 * @description 重复计数
 * <p>
 * 定义一个数组 a = [1, 3, 4, 3, 4, 1, 3], 在这个数组中查找出现次数最多的那个数字
 */
public class CountNumberDuplicates {
    public static void main(String[] args) {
        s1_4();
        s1_5();
        duplicateRemoval();
    }

    /**
     * 时间复杂度: 双层循环, O(n²).
     * 代码中, 几乎没有冗余的无效计算.
     * 如果还需要再去优化, 就要考虑采用一些数据结构方面的手段,
     * 把时间复杂度转移到空间复杂度. eg: s1_5();
     */
    private static void s1_4() {
        int[] a = {1, 3, 4, 3, 4, 1, 3};
        int max_val = -1;
        int time_max = 0;
        int time_tmp = 0;
        for (int i = 0; i < a.length; i++) {
            time_tmp = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    time_tmp++;
                }
                if (time_tmp > time_max) {
                    time_max = time_tmp;
                    max_val = a[i];
                }
            }
        }
        System.out.println("值: " + max_val);
        System.out.println("出现次数: " + time_max);
    }

    /**
     * 定义一个 k-v 结构的字典，用来存放元素-出现次数的 k-v 关系
     */
    private static void s1_5() {
        int[] a = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            if (map.containsKey(key)) {
                /** map.get(key) 获取 key 对应的 value */
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int max_val = -1;
        int time_max = 0;
        int map_position = 0;
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > time_max) {
                time_max = map.get(key);
                max_val = key;
                map_position = count;
            }
            count++;
        }
        System.out.println("值: " + max_val);
        System.out.println("出现次数: " + time_max);
        System.out.println("值在数组中的下标: " + map_position);
        System.out.println(map);
    }

    /**
     * 字符串去重
     */
    public static void duplicateRemoval() {
        String str = "2342asfghgyu56asdasda";
        Map<String, Integer> maps = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            String key = String.valueOf((str.charAt(i)));
            if (!maps.containsKey(key)) {
                maps.put(key, 1);
            } else {
                int val = maps.get(key);
                maps.put(key, val + 1);
            }
        }
        for (Map.Entry i : maps.entrySet()) {
            System.out.println(i.getKey() + "==" + i.getValue());
        }
    }
}
