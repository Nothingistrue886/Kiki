package com.czff.spring.ioc.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 疾风劲草
 * @date 2021/3/18 23:00
 * @description TODO
 */
@Component
public class Dog implements InitializingBean, DisposableBean {

    public Dog() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Dog destroy...");
    }
}
