package com.company.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

public class TestBase02{
    protected SqlSessionFactory factory;
    @Before
    public void init() throws SQLException {
        DataSource dataSource = createDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SysUserMapper.class);
        factory = new SqlSessionFactoryBuilder().build(configuration);
//        System.out.println(factory);
//        SqlSession session = factory.openSession();
//        System.out.println(session);
    }
    @Test
    public void selectById(){
        SqlSession session = factory.openSession();
        SysUserMapper mapper = session.getMapper(SysUserMapper.class);
        Map<String, Object> map = mapper.selectById(16);
        System.out.println(map);
        session.close();
    }

    private DataSource createDataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///jtsys?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
