package com.company.springboot01.service;

/**
 * @author 疾风劲草
 * @date 2020/4/24 21:19
 * @description 业务逻辑
 * 1. 用户行为 CRUD
 * 2. 权限
 * 3. 缓存...
 */
public interface HelloService {
    /**
     * delete log by id
     *
     * @param id
     * @return int
     */
    int deleteLogById(Integer id);

    int updateLogById(Integer id);
}
