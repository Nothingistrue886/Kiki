package com.czff.spring.ioc.beans;

/**
 * @author 疾风劲草
 * @date 2021/3/15 23:21
 * @description TODO
 */
public class Car {
    public Car() {
        System.out.println("Car constructor...");
    }

    public void init() {
        System.out.println("Car init...");
    }

    public void destory() {
        System.out.println("Car destory...");
    }
}
