package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yolo.entities.SysUser;
import com.yolo.mapper.SysUserMapper;
import com.yolo.models.ApplicationException;
import com.yolo.models.ParamException;
import com.yolo.models.ResponseMessage;
import com.yolo.models.adapters.AdapterBiz;
import com.yolo.models.base.MessageModel;
import com.yolo.utils.IdUtil;
import com.yolo.utils.LogUtil;
import com.yolo.utils.MD5Util;
import com.yolo.utils.ParamUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SysUserBiz extends AdapterBiz {

    @Resource
    private SysUserMapper sysUserMapper;


    public MessageModel add(SysUser sysUser) {
        ResponseMessage response = new ResponseMessage();

        int insert = sysUserMapper.insert(sysUser);

        if (insert > 0) {
            response.setMessage("插入失败！");
        } else {
            response.setMessage("插入成功！");
        }
        return response.setSuccess(true);
    }

    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        List select = sysUserMapper.selectList(null);
        return response.setSuccess(true).setObj(select).toMessage();
    }

    public SysUser login(String username, String password, String rememberMe) {

        SysUser sysUser = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(Boolean.parseBoolean(rememberMe));
            try {
                currentUser.login(token);
                sysUser = new SysUser();
                sysUser.setUserName(username);
            } catch (IncorrectCredentialsException e) {
                LogUtil.error("账号密码不匹配");
                throw new IncorrectCredentialsException("账号密码不匹配");
            }
        }

        return sysUser;

    }

    public SysUser register(SysUser sysUser) {

        if (ParamUtil.isNullOrEmpty(sysUser) || ParamUtil.isNullOrEmpty(sysUser.getUserName()) || ParamUtil.isNullOrEmpty(sysUser.getPassword())) {
            throw new ParamException(-1, "必要参数不可空");
        }
        String password = sysUser.getPassword();
        String userName = sysUser.getUserName();
        sysUser.setPassword(MD5Util.toMd5(password.getBytes(), userName.getBytes(), 1024));
        sysUser.setId(IdUtil.uuid());
        sysUser.setUserCode(IdUtil.longId());
        sysUser.setEnable("1");

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        List<SysUser> users = sysUserMapper.selectList(wrapper);

        if (!ParamUtil.isNullOrEmpty(users)) {
            throw new ApplicationException(-1, "此用户名已经存在，请更换用户名");
        }

        sysUserMapper.insert(sysUser);

        return sysUser;

    }

}
