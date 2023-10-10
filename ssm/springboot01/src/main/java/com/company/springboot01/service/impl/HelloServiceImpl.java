package com.company.springboot01.service.impl;

import com.company.springboot01.mapper.SysLogMapper;
import com.company.springboot01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 疾风劲草
 * @date 2020/4/24 21:22
 * @description TODO
 */
@Service
public class HelloServiceImpl implements HelloService { /** is-a */
    /** has-a */
    @Autowired
    private SysLogMapper logMapper;
    @Override
    public int deleteLogById(Integer id) {
        /**
         * 1. 参数校验
         * 2. 执行操作
         * 3. 结果校验
         * 4. 事务
         */
        int rows = Integer.parseInt(null);
        if(id != null){
            rows = logMapper.deleteLogById(id);
        }
        return rows;
    }

    @Override
    public int updateLogById(Integer id) {
        return 0;
    }
}
