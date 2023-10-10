package com.czff.spring.ioc.config;

import com.czff.spring.ioc.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 疾风劲草
 * @date 2021/3/15 23:24
 * @description bean创建-初始化-销毁
 */
@Configuration
@ComponentScan(value = "com.czff.spring.ioc")
public class MyConfigLifeCycleOfBean {

    /**
     * singleton 单实例bean在容器启动时创建对象
     * prototype 多实例bean再每次获取的时候创建对象
     * @return
     */
    @Scope("singleton")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car getCar() {
        return new Car();
    }
}
