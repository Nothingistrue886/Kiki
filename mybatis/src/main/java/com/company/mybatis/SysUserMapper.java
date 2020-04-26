package com.company.mybatis;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;

import java.util.Map;
@CacheNamespace(eviction = LruCache.class)
public interface SysUserMapper {
    @Select(value = "select id,username from sys_users where id=#{id}")
    Map<String,Object> selectById(Integer id);
}
