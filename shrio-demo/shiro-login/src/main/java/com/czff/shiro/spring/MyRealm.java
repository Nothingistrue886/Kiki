package com.czff.shiro.spring;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author cuidi
 * @description 自定义登录认证
 * @date 2022/11/3 11:25
 */
public class MyRealm extends AuthenticatingRealm {
    // shiro 的login方法底层会调用 AuthenticatingRealm 的认证方法进行认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 身份信息：账号
        String principal = token.getPrincipal().toString();
        // 凭证信息：password
        String credentials = token.getCredentials().toString();
        System.out.println(principal + "---" + credentials);
        // 和数据库中的信息进行对比
        String usernameInfo = "zhangsan";
        String passwordInfo = "7174f64b13022acd3c56e2781e098a5f";
        if (usernameInfo.equals(principal)) {
            return new SimpleAuthenticationInfo(
                    usernameInfo,
                    passwordInfo,
                    ByteSource.Util.bytes("salt"),
                    this.getName());
        }
        return null;
    }
}
