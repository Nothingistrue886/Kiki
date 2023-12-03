package com.czff.study.knowledge.collection.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 疾风劲草
 * @date 2023/11/30 20:13
 * @description
 */
public class SingletonTreadFailFast {
    public static void main(String[] args) {
        try {
            // 测试迭代器的remove方法修改集合结构会不会触发checkForComodification异常
            itrRemoveTest();
            System.out.println("----分割线----");
            // 测试集合的remove方法修改集合结构会不会触发checkForComodification异常
            listRemoveTest();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void listRemoveTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String temp : list) {
            System.out.println(temp);
            list.remove(temp);
        }

        //foreach循环等效于迭代器
        /*Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            list.remove(iterator.next());
        }*/
    }

    private static void itrRemoveTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}

