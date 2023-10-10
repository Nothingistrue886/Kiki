package com.czff.mydemo.knowledge.reflect.annotation;

import java.lang.reflect.Field;

/**
 * 调用Annotaion
 */
public class AnnotationTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field field = personClass.getDeclaredField("name");
        System.out.println(field.getName());
        Report report = field.getDeclaredAnnotation(Report.class);
        boolean annotationPresent = field.isAnnotationPresent(Report.class);
        System.out.println(report);
        System.out.println(annotationPresent);
        Person person = new Person();
        person.setName("cuidi");
        field.setAccessible(true);
        // 拿到实例对象的成员变量的值
        Object o = field.get(person);
        System.out.println(o.toString());

    }
}
