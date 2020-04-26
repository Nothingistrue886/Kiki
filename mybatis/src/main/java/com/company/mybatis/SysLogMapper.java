package com.company.mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
// com.company.mybatis.SysLogMapper.selectSysLogs = mappers/SysLogMapper.xml得namespace+id
public interface SysLogMapper {
    List<Map<String, Object>> selectSysLogs(
            // @Param 注解修饰的变量系统底层会存储在map中
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
}
