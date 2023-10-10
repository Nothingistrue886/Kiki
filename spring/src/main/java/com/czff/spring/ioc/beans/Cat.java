package com.czff.spring.ioc.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 疾风劲草
 * @date 2021/3/18 23:06
 * @description TODO
 */
@Component
public class Cat {

    public Cat() {
        System.out.println("Cat constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Cat PostConstruct...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("Cat PreDestroy...");
    }
}
