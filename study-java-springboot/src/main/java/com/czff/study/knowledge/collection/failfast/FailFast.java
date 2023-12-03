package com.czff.study.knowledge.collection.failfast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 疾风劲草
 * @date 2023/11/30 20:13
 * @description
 */
public class FailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String temp : list) {
            list.remove(temp);
        }
    }
}

