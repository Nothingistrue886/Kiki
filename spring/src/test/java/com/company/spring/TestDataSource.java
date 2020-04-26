package com.company.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class TestDataSource {
    @Test
    public void testDataSource() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-configs.xml");
        DruidDataSource bean1 = context.getBean("dataSource", DruidDataSource.class);
        DataSource bean2 = context.getBean("dataSource", DataSource.class);
        System.out.println(bean1 == bean2);
        Connection conn = bean1.getConnection();
        System.out.println(conn);
    }
}
