package com.company.springboot01.service.impl;

import com.company.springboot01.mapper.SysLogMapper;
import com.company.springboot01.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 疾风劲草
 * @date 2020/5/4 11:27
 * @description TODO
 */
@Service
@Slf4j // 注解代替自己定义的log，使用Lombok插件
public class SysLogServiceImpl implements SysLogService {

    /**
     * 自己定义 log
     */
    /*private static final Logger LOGGER = LoggerFactory.getLogger(SysLogServiceImpl.class);*/

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int deleteLogsById(Integer... ids) {
        int rows = sysLogMapper.deleteLogsById(ids);
        log.info("delete row = " + rows);
        /*LOGGER.info("delete row = " + rows);*/
        System.out.println(rows);
        return rows;
    }
}
