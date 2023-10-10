package com.czff.spring.ioc;

import com.czff.spring.ioc.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 疾风劲草
 * @date 2021/3/11 22:16
 * @description TODO
 */
public class IocTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

    @Test
    public void getPersonTest(){
        /*Person bean = context.getBean(Person.class);
        System.out.println(bean);
        Person bean1 = (Person) context.getBean("getPerson");
        System.out.println(bean1);
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println("Bean为Person类型的名称：" + name);
        }*/
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中注册的Beans：" + beanDefinitionName);
        }
    }

    @Test
    public void getColorFactoryBeanTest(){
        //Color bean = context.getBean(Color.class);
        Object bean = context.getBean("factoryBean");
        Object bean2 = context.getBean("&factoryBean");
        System.out.println(bean.getClass()); // class com.czff.spring.ioc.beans.Color
        System.out.println(bean2.getClass());// class com.czff.spring.ioc.beans.ColorFactoryBean
    }
}
