package com.czff.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author 疾风劲草
 * @date 2021/4/11 21:05
 * @description TODO
 */
@Aspect
public class CalculateAspect {

    /**
     * 抽取公共的切入点表达式
     */
    @Pointcut(value = "execution(* com.czff.spring.aop.Calculate.*(..))")
    public void pointCut() { }

    @Before(value = "pointCut()")
    public void LogStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("start..." + name);
    }

    @After("pointCut()")
    public void LogEnd() {
        System.out.println("end...");
    }

    @AfterReturning(value = "execution(public * com.czff.spring.aop.Calculate.*(..))", returning = "result")
    public void LogReturning(Object result) {
        System.out.println("returning..." + result);
    }

    @AfterThrowing(value = "execution(public * com.czff.spring.aop.Calculate.*(..))", throwing = "throwing")
    public void LogException(Exception throwing) {
        System.out.println("exception..." + throwing);
    }

    /**
     * 环绕通知,动态代理,手动推进目标方法进行 jionPoint.proceed()
     */
//    @Around("execution(public * com.czff.spring.aop.Calculate.*(..))")
//    public void LogAround() {
//        System.out.println("around...");
//    }
}
