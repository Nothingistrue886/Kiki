package com.czff.shiro.spring;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author cuidi
 * @description
 * @date 2022/11/3 10:22
 */
public class ShiroRun {

    public static void main(String[] args) {
        /// 认证
        // 1.获取security对象
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory();
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 2.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 3.获取token
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");
        // 4.ok
        try {
            subject.login(token);
            System.out.println("login ok");
            /// 授权
            // 1.判断角色
            boolean hasRole = subject.hasRole("role1");
            System.out.println("hasRole = " + hasRole);
            // 2.判断权限
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println("permitted = " + permitted);
        } catch (AuthenticationException e) {
            System.out.println("login error");
            e.printStackTrace();
        }
    }
}
