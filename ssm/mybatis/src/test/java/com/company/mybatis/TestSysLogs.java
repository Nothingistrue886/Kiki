package com.company.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSysLogs extends TestBase {
    @Test
    public void testDeleteSysLog() {
        SqlSession session = factory.openSession(true);
        String statement = "com.company.mybatis.SysLogMapper.delectSysLog";
        int i = session.delete(statement, 20);
        System.out.println("删除元素" + i + "个");
        session.close();
    }
    @Test
    public void testSelectSysLogs1() {
        SqlSession session = factory.openSession();
        String statement = "com.company.mybatis.SysLogMapper.selectSysLogs";
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("startIndex",0);
        hashMap.put("pageSize",3);
        List<HashMap<String,Object>> list = session.selectList(statement, hashMap);
        System.out.println(list);
        session.close();
    }
    @Test
    public void testSelectSysLogs2() {
        SqlSession session = factory.openSession();                     // factory 为单例模式
        SysLogMapper mapper = session.getMapper(SysLogMapper.class);    // JDK 动态代理
        List<Map<String, Object>> list = mapper.selectSysLogs(0, 5);
        System.out.println(list);
        session.close();
    }

}
