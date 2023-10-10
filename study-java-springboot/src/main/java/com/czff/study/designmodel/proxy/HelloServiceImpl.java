package com.czff.mydemo.designmodel.proxy;

/**
 * @author cuidi
 * @date 2020/12/23 16:02
 * @description 目标对象
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String name) {
        System.out.println("Hello World!" + name);
    }
}
