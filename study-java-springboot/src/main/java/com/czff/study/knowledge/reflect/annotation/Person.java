package com.czff.mydemo.knowledge.reflect.annotation;

/**
 * @author cuidi
 * @date 2022/6/9 15:07
 * @description
 */
public class Person {
    @Report
    private String name;

    public Person() {
    }

    public static void main(String[] args) {
        System.out.println("Helloworld");
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
