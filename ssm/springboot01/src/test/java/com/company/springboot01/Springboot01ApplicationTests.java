package com.company.springboot01;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {
    @Autowired
    protected ApplicationContext context;
    @Autowired
    protected DataSource dataSource;
    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    @Test
    public void contextLoads() {
        System.out.println(context);
    }

    @Test
    public void dataSourceTest() {
        Assert.assertNotEquals(null, dataSource);
        System.out.println(dataSource.getClass());
    }
    @Test
    public void setSqlSessionFactoryTest(){
        /** sqlSessionFactory对象依赖于数据源 */
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session);
    }
}
