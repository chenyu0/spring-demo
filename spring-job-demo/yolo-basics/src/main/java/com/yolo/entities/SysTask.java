package com.yolo.entities;

import java.util.Date;

public class SysTask {
    private String id;

    private Long taskCode;

    private String taskName;

    private String taskType;

    private String taskSchema;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String taskSql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(Long taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskSchema() {
        return taskSchema;
    }

    public void setTaskSchema(String taskSchema) {
        this.taskSchema = taskSchema == null ? null : taskSchema.trim();
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

    public String getTaskSql() {
        return taskSql;
    }

    public void setTaskSql(String taskSql) {
        this.taskSql = taskSql == null ? null : taskSql.trim();
    }
}