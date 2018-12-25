package com.yolo.realms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yolo.entities.SysUser;
import com.yolo.mapper.SysRoleMapper;
import com.yolo.mapper.SysUserMapper;
import com.yolo.mapper.SysUserRoleMapper;
import com.yolo.models.ParamException;
import com.yolo.utils.LogUtil;
import com.yolo.utils.ParamUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/24
 * Time: 9:57
 */


public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LogUtil.info("权限认证...doGetAuthorizationInfo..." + principalCollection.toString());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        if (ParamUtil.isNullOrEmpty(username)) {
            throw new ParamException(-1, "用户名称参数不可为空");
        }

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (ParamUtil.isNullOrEmpty(sysUser)) {
            throw new UnknownAccountException("当前用户：" + username + " 不存在！");
        }
        if (!"1".equals(sysUser.getEnable())) {
            throw new LockedAccountException("当前用户：" + username + " 未启用或者已作废");
        }

        String password = sysUser.getPassword();

        String realmName = getName();
        ByteSource salt = ByteSource.Util.bytes(username);

        return new SimpleAuthenticationInfo(sysUser, password, salt, realmName);
    }
}
