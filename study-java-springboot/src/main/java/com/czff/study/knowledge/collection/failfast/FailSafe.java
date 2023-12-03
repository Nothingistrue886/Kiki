package com.czff.study.knowledge.collection.failfast;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 疾风劲草
 * @date 2023/12/3 20:04
 * @description
 */
public class FailSafe {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String temp : list) {
            list.remove(temp);
        }
    }
}


