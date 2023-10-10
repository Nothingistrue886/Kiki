package com.czff.mydemo.knowledge.reflect.person;

import java.lang.reflect.Field;

/**
 * @author 疾风劲草
 * @date 2021/7/17 12:16
 * @description
 */
public class FooTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            System.out.println(name);
            Class<?> sonClass = declaredField.getType();
            String name2 = declaredField.getType().getName();
            //判断一下属性类型如果是son进入
            if("com.czff.study.knowledge.reflect.person.Son".equals(name2)){
                Field[] declaredFields1 = sonClass.getDeclaredFields();
                for (Field field : declaredFields1) {
                    String name1 = field.getName();
                    System.out.println(name1);
                }
            }

        }
    }
}
