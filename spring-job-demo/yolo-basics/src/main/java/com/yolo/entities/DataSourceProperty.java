package com.yolo.entities;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 17:03
 */


public class DataSourceProperty {
    private String type;
    private String url;
    private String driverClassName;
    private String username;
    private String password;

    private Boolean readOnly;

    //    private String mapperLocation;
    //
    //    private String mybatisConfig;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }
}
