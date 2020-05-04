package com.company.springboot01.service;

/**
 * @author 疾风劲草
 * @date 2020/5/4 11:26
 * @description TODO
 */
public interface SysLogService {
    /**
     * delete objects by id
     * @param ids
     * @return
     */
    int deleteLogsById(Integer... ids);
}
