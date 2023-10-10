package com.czff.mydemo.knowledge.generic;

/**
 * @description 泛型通配符
 * @author cuidi
 * @date 2023/6/1 18:35
 */
public class Wildcard {

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        showKeyValue(gNumber);

        showKeyValue1(gNumber);

        showKeyValue2(gInteger);
        showKeyValue2(gNumber);
    }
    public static void showKeyValue(Generic<Number> obj){
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    // 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
    public static void showKeyValue2(Generic<? extends Number> obj){
        System.out.println("泛型测试 key value is " + obj.getKey());
    }
}
