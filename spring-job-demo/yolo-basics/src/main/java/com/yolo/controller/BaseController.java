package com.yolo.controller;

import com.yolo.entities.SysUser;
import com.yolo.models.ApplicationException;
import com.yolo.utils.ParamUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


public class BaseController {

    public BaseController() {
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public HttpSession getSession() {
        return this.getRequest().getSession();
    }

    public Object getAttribute(String key) {
        Object obj = this.getRequest().getAttribute(key);
        return null == obj ? this.getSession().getAttribute(key) : obj;
    }

    public <T> T getAttribute(String key, Class<T> clazz) {
        Object obj = this.getRequest().getAttribute(key);
        return (T) (null == obj ? this.getSession().getAttribute(key) : obj);
    }

    public void removeAttribute(String key) {
        this.getRequest().removeAttribute(key);
        this.getSession().removeAttribute(key);
    }

    public String getParam(String name) {
        return this.getRequest().getParameter(name);
    }

    public String[] getParams(String name) {
        return this.getRequest().getParameterValues(name);
    }

    public SysUser currentLoginUser(){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            throw new ApplicationException("用户尚未登录！！");
        }
        SysUser principal = (SysUser) subject.getPrincipal();
        return ParamUtil.isNullOrEmpty(principal)?(SysUser) getSession().getAttribute("user"):principal;
    }

    public Map getParamsMap(){
        Map<String,Object> map = new HashMap<>();
        Enumeration<String> parameterNames = this.getRequest().getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key = parameterNames.nextElement();
            String value = this.getRequest().getParameter(key);
            map.put(key,value);
        }
        return map;
    }
}
