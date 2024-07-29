package com.czff.study.knowledge.features.jdk8.lambda;

import java.util.Comparator;

/**
 * @author 疾风劲草
 * @date 2024/7/29 09:34
 * @description 方法引用和lambda表达式都是对函数式接口的实例化
 * 举例：(o1,o2) -> Integer.compare(o1,o2);
 * -> ：lambda 操作符 或 箭头操作符
 * -> 左边：lambda 形参列表 （其实就是接口中的抽象方法的形参列表）
 * -> 右边：lambda 体（其实就是重写的抽象方法的方法体）
 **/
public class LambdaTest1 {


    // Runnable接口使用lambda表达式前后对比
    public void test1(){
        //未使用Lambda表达式的写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lambda!");
            }
        };
        r1.run();

        System.out.println("========================");

        //Lamdba表达式写法
        Runnable r2 = () -> System.out.println("hi Lambda!");
        r2.run();
    }

    // 使用Comparator接口
    public void test2(){
        //未使用Lambda表达式的写法
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 32);
        System.out.println(compare1);//-1
        System.out.println("===================");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(54, 21);
        System.out.println(compare2);//1
        System.out.println("===================");

        //方法引用
        Comparator<Integer> cpm3 = Integer::compareTo;
        int compare3 = cpm3.compare(12, 12);
        System.out.println(compare3);//0
    }



}
