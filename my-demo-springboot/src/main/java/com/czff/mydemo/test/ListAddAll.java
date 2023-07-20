package com.czff.mydemo.test;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuidi
 * @description
 * @date 2022/12/8 20:26
 */
public class ListAddAll {
    public static void main(String[] args) {

        String[] str = {
                "1", "1"
        };
        List<String> strings = Arrays.asList(str);
        strings.forEach(System.out::println);

//        List<Dog> list = new ArrayList<>();
//        List<Dog> list1 = new ArrayList<>();
//        List<Dog> list2 = new ArrayList<>();
//        Dog dog1 = new Dog("1");
//        Dog dog2 = new Dog("2");
//        list1.add(dog1);
//        list2.add(dog2);
//        list.addAll(list1);
//        list.addAll(list2);
//        list.forEach(e -> System.out.println(e.getName()));
//        list.forEach(System.out::println);
//        for (Dog dog : list) {
//            System.out.println(dog);
//        }
    }

    @AllArgsConstructor
    @Data
    static
    class Dog {
        private String name;
    }
}
