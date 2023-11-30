package com.czff.study.knowledge.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * @author 疾风劲草
 * @date 2023/11/26 18:26
 * @description 实现简单的Spring扩展
 */
//@Component // 注释掉是为了更好的debug spring bean 的创建流程。整个流程中会调用9次BeanFactoryPostProcessor
public class MySpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition aPerson = (AbstractBeanDefinition) beanFactory.getBeanDefinition("person");
        aPerson.setBeanClass(Student.class);

    }
}
