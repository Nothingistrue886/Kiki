package com.company.springboot01.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 疾风劲草
 * @date 2020/4/26 1:05
 * @description TODO
 */
@Mapper
public interface SysLogMapper {
    @Delete("delete from sys_logs where id=#{id}")
    int deleteLogById(@Param("id") Integer id);

    /**
     * delete logs by ids 动态删除
     * @param ids
     * @return
     */
    int deleteLogsById(@Param("ids") Integer... ids);
    // 参数为数组形式
    //int deleteLogsById(@Param("ids") Integer[] ids);
}
