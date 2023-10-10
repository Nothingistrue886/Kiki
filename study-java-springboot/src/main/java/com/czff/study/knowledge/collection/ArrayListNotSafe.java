package com.czff.mydemo.knowledge.collection;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 疾风劲草
 * @date 2021/7/24 10:12
 * @description 解决ArrayList线程不安全
 */
public class ArrayListNotSafe {

    public static void main(String[] args) {

        // listarrayconversion<String> arrayList = new ArrayList<>();
        // 方案一
        // listarrayconversion<String> vectorList = new Vector<>();
        // 方案二
        // listarrayconversion<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        // 方案三(推荐)
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(copyOnWriteArrayList);
            }, String.valueOf(i)).start();

        }
    }
}
