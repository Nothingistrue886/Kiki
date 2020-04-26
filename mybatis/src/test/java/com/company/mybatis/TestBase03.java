package com.company.mybatis;

import org.junit.Test;

public class TestBase03 extends TestBase02 {
    @Test
    public void testCache(){
        selectById();
        selectById();
//        Log log = LogFactory.getLog(TestBase03.class);
//        log.debug("thi is a dubuger");
    }
    @Override
    public void selectById() {
        super.selectById();
    }
}
