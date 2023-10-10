package com.czff.mydemo.designmodel.proxy;

/**
 * @author cuidi
 * @date 2020/12/23 16:08
 * @description 反射是动态代理的一种实现方式。
 * 1、JDK动态代理：java.lang.reflect 包中的Proxy类和InvocationHandler接口提供了生成动态代理类的能力。
 * 2、Cglib动态代理：Cglib (Code Generation Library)是一个第三方代码生成类库，运行时在内存中动态生成一个子类对象从而实现对目标对象功能的扩展。
 * 使用动态代理的对象必须实现一个或多个接口
 * 使用cglib代理的对象则无需实现接口，达到代理类无侵入。
 */
public class ProxyMainTest {
    public static void main(String[] args) {
        // 静态代理
        //staticProxyMethod();
        // jdk动态代理
        JdkDynamicProxy1();
    }

    private static void JdkDynamicProxy1() {
        //设置为true,会在工程根目录生成$Proxy0.class代理类（com.sun.proxy.$Proxy0.class）
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String saveGeneratedFiles = System.getProperty("sun.misc.ProxyGenerator.saveGeneratedFiles");
        System.out.println(saveGeneratedFiles);

        HelloService service = new HelloServiceImpl();
        JdkDynamicProxy2 handler = new JdkDynamicProxy2(service);
        HelloService proxy = (HelloService) handler.getProxy();
        proxy.say(" by 崔作非");
    }

    private static void staticProxyMethod() {
        HelloService helloService = new HelloServiceImpl();
        StaticProxyImpl staticProxy = new StaticProxyImpl(helloService);
        staticProxy.say(" by 疾风劲草");
    }
}
