package com.czff.shiro.springboot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.List;

/**
 * @author cuidi
 * @description springboot 整合 shiro 自定义 Realm extends AuthorizingRealm
 * @date 2022/11/3 14:33
 */
@Component
public class MyRealm extends AuthorizingRealm {
    // 自定义授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1.获取用户信息
        String principal = principals.getPrimaryPrincipal().toString();
        // 2.查询数据库
        String role = principal.concat("role");
        String permission = principal.concat("permission");
        // 3.创建对象，封装当前用户的角色，权限信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取角色
        simpleAuthorizationInfo.addRole(role);
        simpleAuthorizationInfo.addStringPermission(permission);
        return simpleAuthorizationInfo;
    }

    // 自定义登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 身份信息：账号
        String principal = token.getPrincipal().toString();
        // 凭证信息：password
        String credentials = token.getCredentials().toString();
        System.out.println(principal + "---" + credentials);
        // 和数据库中的信息进行对比
//        String usernameInfo = "zhangsan";
        String passwordInfo = "7174f64b13022acd3c56e2781e098a5f";
        return new SimpleAuthenticationInfo(
                principal,
                passwordInfo,
                ByteSource.Util.bytes("salt"),
                this.getName());
    }
}
