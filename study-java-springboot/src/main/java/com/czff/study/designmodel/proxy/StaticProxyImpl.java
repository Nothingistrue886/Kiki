package com.czff.study.designmodel.proxy;

/**
 * @author cuidi
 * @date 2020/12/23 15:28
 * @description 代理对象
 */
public class StaticProxyImpl implements HelloService {

    private final HelloService helloService;

    public StaticProxyImpl(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void say(String name) {
        System.out.println("start Proxy");
        helloService.say(name);
        System.out.println("end Proxy");
    }
}
