package com.czff.shiro.springboot;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuidi
 * @description 配置类
 * 创建 管理器、过滤器
 * @date 2022/11/3 15:10
 */
@Configuration
public class ShiroConfig {


    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(new MyRealm());
        return securityManager;
    }
}
