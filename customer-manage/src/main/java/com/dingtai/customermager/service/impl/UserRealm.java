package com.dingtai.customermager.service.impl;


import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.service.PermissionService;
import com.dingtai.customermager.service.UserService;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.UserEntity;
import com.github.pagehelper.util.StringUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * 认证
 *
 * @author wangyanhui
 * @date 2018-03-26 19:43
 */
@Component
public class UserRealm extends AuthorizingRealm {

    /**
     * 用户信息Mapper
     */
    @Autowired
    private UserService userService;
    /**
     * 权限信息Mapper
     */
    @Autowired
    private PermissionService permissionService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserEntity user = (UserEntity) principals.getPrimaryPrincipal();
        Long userId = user.getId();
        List<String> permsList = null;
        permsList = permissionService.getCurrentUserAllPerms();

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for (String perms : permsList) {
            if (StringUtil.isEmpty(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);

        Set<String> roleSet = new HashSet<String>();
        Result<GetUserListResp> userInfo = userService.getUserByUserId(userId);
        if (userInfo != null && userInfo.getData() != null && userInfo.getData().getRoleName() != null) {
            String roleName = userInfo.getData().getRoleName();
            String[] roleNames = roleName.split(",");
            if (roleNames != null && roleNames.length > 0) {
                for (String role : roleNames) {
                    roleSet.add(role);
                }
            }
        }
        info.setRoles(roleSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //查询用户信息
        List<UserEntity> users = userService.queryByUserName(userName);

        //账号不存在
        if (users == null || users.size() == 0) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //密码错误
        if (!password.equals(users.get(0).getPassword())) {
                throw new IncorrectCredentialsException("账号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(users.get(0), password, getName());
        return info;
    }
}
