package com.czff.study.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cuidi
 * @date 2020/12/29 10:43
 * @description jdk动态代理
 * JDK提供了Java.lang.reflect.Proxy类来实现动态代理的，可通过它的newProxyInstance来获得代理实现类。
 * 同时对于代理的接口的实际处理，是一个java.lang.reflect.InvocationHandler，它提供了一个invoke方法供实现者提供相应的代理逻辑的实现。
 * <p>
 * JDK的动态代理为什么不支持对实现类的代理，只支持接口的代理？
 * <p>
 * 动态生成代理类特性：
 * 1.继承了Proxy类，实现了代理的接口，由于java不能多继承，这里已经继承了Proxy类了，不能再继承其他的类，所以JDK的动态代理不支持对实现类的代理，只支持接口的代理。
 * 2.提供了一个使用InvocationHandler作为参数的构造方法。
 * 3.生成静态代码块来初始化接口中方法的Method对象，以及Object类的equals、hashCode、toString方法。
 * 4.重写了Object类的equals、hashCode、toString，它们都只是简单的调用了InvocationHandler的invoke方法，即可以对其进行特殊的操作，也就是说JDK的动态代理还可以代理上述三个方法。
 * 5.代理类实现代理接口的say方法中，只是简单的调用了InvocationHandler的invoke方法，我们可以在invoke方法中进行一些特殊操作，甚至不调用实现的方法，直接返回。
 * 链接：https://www.cnblogs.com/sidesky/p/9288183.html
 */
public class JdkDynamicProxy2 implements InvocationHandler {

    private Object target;

    public JdkDynamicProxy2(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start Proxy");
        if ("say".equals(method.getName())) {
            System.out.println(target.getClass().getName() + "." + method.getName());
        }
        method.invoke(target, args);
        System.out.println("end Proxy");
        return null;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
