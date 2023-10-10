package com.czff.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 疾风劲草
 * @date 2021/4/11 21:03
 * @description TODO
 */
@EnableAspectJAutoProxy
@Configuration
public class AspectConfig {
    @Bean
    public Calculate calculate() {
        return new Calculate();
    }

    @Bean
    public CalculateAspect calculateAspecte() {
        return new CalculateAspect();
    }

}
