package com.yolo.entities;

import javax.persistence.Id;
import java.util.Date;

public class SysCenter {
    @Id
    private String id;

    private String centerCode;

    private String centerName;

    private String centerType;

    private String centerDatasource;

    private String centerParentCode;

    private String enableCache;

    private String enbleConstant;

    private String dataType;

    private String param;

    private String requestParam;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode == null ? null : centerCode.trim();
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName == null ? null : centerName.trim();
    }

    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType == null ? null : centerType.trim();
    }

    public String getCenterDatasource() {
        return centerDatasource;
    }

    public void setCenterDatasource(String centerDatasource) {
        this.centerDatasource = centerDatasource == null ? null : centerDatasource.trim();
    }

    public String getCenterParentCode() {
        return centerParentCode;
    }

    public void setCenterParentCode(String centerParentCode) {
        this.centerParentCode = centerParentCode == null ? null : centerParentCode.trim();
    }

    public String getEnableCache() {
        return enableCache;
    }

    public void setEnableCache(String enableCache) {
        this.enableCache = enableCache == null ? null : enableCache.trim();
    }

    public String getEnbleConstant() {
        return enbleConstant;
    }

    public void setEnbleConstant(String enbleConstant) {
        this.enbleConstant = enbleConstant == null ? null : enbleConstant.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}