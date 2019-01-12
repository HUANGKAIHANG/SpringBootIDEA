package com.hkh.SpringBootIDEA.config;

import com.hkh.SpringBootIDEA.domain.SysPermission;
import com.hkh.SpringBootIDEA.domain.SysRole;
import com.hkh.SpringBootIDEA.domain.UserInfo;
import com.hkh.SpringBootIDEA.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("MyShiroRealm的授权方法执行。。。");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            System.out.println("角色=" + role.getRole());
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                System.out.println("拥有权限=" + p.getPermission());
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        System.out.println("授权验证结束");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm的认证方法执行。。。");
        //获取用户的输入账号
        String username = (String) token.getPrincipal();
        System.out.println("token username=" + username);
        System.out.println("Credentials=" + token.getCredentials());
        //通过username去数据库中找数据
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("UserInfo=" + userInfo);
        if (userInfo == null) {
            return null;
        }
        System.out.println("密码=" + userInfo.getPassword());
        System.out.println("盐=" + userInfo.getCredentialsSalt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()), //=username+slat
                getName() //realm name
        );
        System.out.println("认证验证结束");
        return authenticationInfo;
    }
}
