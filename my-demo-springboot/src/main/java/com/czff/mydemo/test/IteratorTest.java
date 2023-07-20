package com.czff.mydemo.test;/**
 * @description
 * @author cuidi
 * @date 2022/12/1 17:27
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author cuidi
 * @date 2022/12/1 17:27
 */
public class IteratorTest {
    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a,b,c");
        map.put("2", "abc");
        map.put("3", "1,2,3");
        List<String> list = Arrays.asList("a,b,c", "bc", "1,2,3");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String value = next.getValue();
            if (!list.contains(value)) {
                iterator.remove();
            }
        }
        map.forEach((key, value) -> System.out.println(key + "---" + value));
    }
}
