package com.czff.spring.ioc.config;

import com.czff.spring.ioc.beans.ColorFactoryBean;
import com.czff.spring.ioc.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * @author 疾风劲草
 * @date 2021/3/11 22:15
 * @description TODO
 */
@Configuration
//@ComponentScan(value = {"com.czff.spring.ioc"},
//        excludeFilters = {@ComponentScan.Filter(classes = Service.class)})
//@ComponentScan(value = "com.czff.spring.ioc",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)})
public class MyConfig {

    /**
     * 容器中注册一个bean其id为方法名
     *
     * @return
     */
    @Scope
    @Bean
    public Person getPerson() {
        return new Person("疾风劲草", 18);
    }

    @Bean
    public ColorFactoryBean factoryBean() {
        return new ColorFactoryBean();
    }
}
