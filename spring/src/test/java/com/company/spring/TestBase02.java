package com.company.spring;

import com.company.spring.beans.DataSourceBean;
import com.company.spring.beans.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBase02 {
    protected AnnotationConfigApplicationContext config;

    @Before
    public void init() {
        config = new AnnotationConfigApplicationContext(SpringConfigs.class);
    }

    @Test
    public void testConfigBean() {
        System.out.println(config);
        DataSourceBean bean = config.getBean(DataSourceBean.class);
        System.out.println("datasoure bean: " + bean);
    }

    @Test
    public void testSearch(){
        SearchService bean = config.getBean(SearchService.class);
        System.out.println(bean.search());
    }
}
