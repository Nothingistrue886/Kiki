package com.company.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author 疾风劲草
 * @date 2020/4/23 14:57
 * @description TODO
 */
@Configuration
@ComponentScan("com.company.springmvc")
@EnableWebMvc
/**
 * @EnableWebMvc
 * 告诉 spring 启用 mvc 的一些默认配置 == <mvc:annotation-driven/>
 * 两种方式重写:
 * 1. 添加 @EnableWebMvc 注解需要实现
 * 2. NO @EnableWebMvc  需要继承 WebMvcConfigurationSupport
 */
public class SpringmvcConfig extends WebMvcConfigurationSupport {
    /** 配置前端控制器放行资源 == <mvc:default-servlet-handler/> */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /** 配置视图解析器 */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/",".html");
    }
}
