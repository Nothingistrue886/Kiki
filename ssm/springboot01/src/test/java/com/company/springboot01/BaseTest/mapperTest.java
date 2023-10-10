package com.company.springboot01.BaseTest;

import com.company.springboot01.mapper.SysLogMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 疾风劲草
 * @date 2020/4/24 16:02
 * @description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class mapperTest {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    @Autowired
    protected SysLogMapper logMapper;
    @Test
    public void deleteByIdTest(){
        int num = logMapper.deleteLogById(15);
        System.out.println("num=" + num);
        Assert.assertNotEquals(1,num);
        logger.info("num=" + num);
    }
}
