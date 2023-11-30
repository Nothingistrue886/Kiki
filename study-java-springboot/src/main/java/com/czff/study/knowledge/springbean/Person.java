package com.czff.study.knowledge.springbean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 疾风劲草
 * @date 2023/11/24 11:01
 * @description
 */
@Data
@Component
public class Person implements ApplicationContextAware {
    @Autowired
    Student student;

    private String name;

    public Person() {
        System.out.println("this is Person constructor");
    }

    void sayHello() {
        System.out.println("hello world!");
    }

    @PostConstruct //生命周期初始化回调方法
    void lifeInit() {
        System.out.println("person Init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("person Aware");
    }
}
