package com.czff.spring.ioc;

import com.czff.spring.ioc.config.MyConfigLifeCycleOfBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 疾风劲草
 * @date 2021/3/15 23:27
 * @description TODO
 */
public class IocLifeCycleOfBeanTest {



    @Test
    public void getCarTest(){
        // 创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigLifeCycleOfBean.class);
        System.out.println("ioc 容器创建完成...");
//        Car bean = context.getBean(Car.class);

        // 关闭ioc容器
        context.close();
    }
}
