package com.company.springboot01.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 疾风劲草
 * @date 2020/4/24 15:43
 * @description TODO
 */

@Mapper
public interface SysLogMapper {
    /**
     * delete log by id
     * @param id
     * @return int
     */
    @Delete("delete from sys_logs where id = #{id}")
    int deleteLogById(@Param("id") Integer id);
}
