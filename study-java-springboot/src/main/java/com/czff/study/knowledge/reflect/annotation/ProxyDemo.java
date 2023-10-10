package com.czff.mydemo.knowledge.reflect.annotation;


import com.czff.study.knowledge.reflect.annotation.Person;
import com.czff.study.knowledge.reflect.annotation.Report;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;


/**
 * @author cuidi
 * @date 2021/1/4 15:12
 * @description 通过反射动态修改注解属性值,
 * java.lang.reflect.Proxy.getInvocationHandler(Object proxy)方法返回指定代理实例的调用处理程序。
 */
public class ProxyDemo {
    public static void main(String[] args) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        Report annotation = name.getAnnotation(Report.class);
        System.out.println(annotation.toString());
        System.out.println("=======================================================");

        InvocationHandler reportHandler = Proxy.getInvocationHandler(annotation);
        Field[] fields = reportHandler.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            if ("memberValues".equals(field.getName())) {
                field.setAccessible(true);
                Map map = (Map) field.get(reportHandler);
                map.put("id", field.getName());
                System.out.println(map.toString());
                map.forEach((k, v) -> {
                    System.out.println("key: " + k + ", " + "value: " + v);
                });
            }
        }
    }
}