package com.jc.system.shiro;
import com.jc.system.entity.SysPermission;
import com.jc.system.entity.SysUser;
import com.jc.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    //注入业务实现
    @Autowired
    private SysUserService userService;

    //处理授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从身份集合中获取当前主体的身份信息
        Object principal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String email=(String)principal;
            List<SysPermission> sysPermissions = userService.findPermissionsByLoginName(email);
            //权限去重
            Set<String> perms = new HashSet<>();
            for (SysPermission perm: sysPermissions) {
                String menu_url = perm.getPer_name();
                perms.add(menu_url);
            }
            //授权
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setStringPermissions(perms);
            return authorizationInfo;
        }
        return null;
    }


    //处理认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取身份信息
        Object principal = token.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String email = (String)principal;
            //调用业务逻辑查询用户信息
            SysUser sysUser = userService.findUserInfoByEmail(email);
            //加密加盐
//            ByteSource source=ByteSource.Util.bytes(loginName);
            //带加盐的认证
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(email, sysUser.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
    }
}
