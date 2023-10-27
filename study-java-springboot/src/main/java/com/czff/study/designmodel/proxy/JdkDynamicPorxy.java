package com.czff.study.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cuidi
 * @date 2020/12/22 14:48
 * @description 先定义了接口Hello，但是我们并不去编写实现类，而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象。
 */
public class JdkDynamicPorxy {
    public static void main(String[] args) {
        // InvocationHandler实例，负责实现接口的方法调用
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                // 过滤方法
                if ("say".equals(method.getName())) {
                    System.out.println("Hello World!" + args[0]);
                }
                return null;
            }
        };
        // Proxy.newProxyInstance创建interface实例
        HelloService helloServiceProxy = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class[]{HelloService.class},
                handler);
        helloServiceProxy.say(" by 崔作非");
    }
}
