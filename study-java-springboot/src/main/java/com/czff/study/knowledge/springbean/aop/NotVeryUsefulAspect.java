package com.czff.study.knowledge.springbean.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 疾风劲草
 * @date 2023/11/28 21:51
 * @description
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

    @Pointcut("within(com.czff.study.knowledge.springbean.Student)")
    public void sayBye() {
        System.out.println("Pointcut");
    }

    @Before("sayBye()")
    public void doAccessCheck() {
        System.out.println("before");
    }
}
