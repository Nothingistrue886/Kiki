package com.czff.study.knowledge.collection.looptraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author cuidi
 *  2022/6/9 15:07
 * @description 遍历hashmap
 */
public class HashMapIterator {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>(16);
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");



        useIterator(map, students);
        for (Student s : students) {
            System.out.println(s.getId() + "-----" + s.getName());
        }

        System.out.println("=======================================");

        students.clear();
        entrySet(map, students);
        for (Student s : students) {
            System.out.println(s.getId() + ":::::" + s.getName());
        }

    }

    /**
     * 第二种遍历方式
     * 使用迭代器的 remove 方法删除数据
     */
    private static void useIterator(Map<String, String> map, ArrayList<Student> students) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Student student = new Student();
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            if("b".equals(value)) {
                it.remove();
            } else {
                student.setId(key);
                student.setName(value);
                students.add(student);
            }
        }
    }

    /**
     * 第一种遍历方式
     * keySet()
     * entrySet()
     * 1. 在循环外面 new 对象，循环赋值时会指向同一个对象，值被覆盖
     * 2. 在循环里面 new 对象，循环赋值会指向不同对象
     */
    private static void entrySet(Map<String, String> map, ArrayList<Student> students) {
        /* Student student = new Student(); */
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Student student = new Student();
            student.setId(entry.getKey());
            student.setName(entry.getValue());
            students.add(student);
        }
    }
}
