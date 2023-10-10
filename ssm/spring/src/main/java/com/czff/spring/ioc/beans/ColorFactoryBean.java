package com.czff.spring.ioc.beans;

import org.springframework.beans.factory.FactoryBean;


/**
 * @author 疾风劲草
 * @date 2021/3/15 23:05
 * @description
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
