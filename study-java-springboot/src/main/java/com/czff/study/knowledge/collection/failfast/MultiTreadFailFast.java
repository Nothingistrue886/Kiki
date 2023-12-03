package com.czff.study.knowledge.collection.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 疾风劲草
 * @date 2023/11/30 20:13
 * @description
 */
public class MultiTreadFailFast {
    private static List<String> list = new ArrayList<>();

    /**
     * 多线程情况测试
     */
    public static void main(String[] args) {
        list.add("1");
        list.add("2");
        list.add("3");
        // 同时启动两个线程对list进行操作！
        new ErgodicThread().start();
        new ModifyThread().start();
    }

    /**
     * 遍历集合的线程
     */
    private static class ErgodicThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 10) {
                printAll();
                i++;
            }
        }
    }

    /**
     * 修改集合的线程
     */
    private static class ModifyThread extends Thread {
        @Override
        public void run() {
            list.add("5");
        }
    }

    /**
     * 遍历集合
     */
    private static void printAll() {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println();
    }
}

