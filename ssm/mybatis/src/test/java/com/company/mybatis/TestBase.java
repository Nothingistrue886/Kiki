package com.company.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class TestBase {
    /**
     * 借助此对象创建SqlSession(通过此对象
     * 实现与数据库之间的会话)
     */
    protected SqlSessionFactory factory;
    /**
     * 此方会在@Test注解修饰的方法之前执行,
     * 通常用于做一些初始化操作(方法名自己定义)
     */
    @Before
    public void init()throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-configs.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        //系统底层建造者模式构建工厂对象(此对象构建过程相对复杂)
        System.out.println(factory);
    }
    @Test
    public void testSqlSessionConnection(){
        SqlSession session=factory.openSession();
        Connection conn=session.getConnection();
        System.out.println(conn);
        session.close();

    }

}
