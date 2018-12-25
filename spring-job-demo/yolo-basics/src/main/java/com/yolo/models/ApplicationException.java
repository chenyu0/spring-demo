package com.yolo.models;

import java.io.Serializable;

public class ApplicationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 100L;
    private Integer code;

    private String message;
    private AppExceptionEnum appExceptionEnum;

    public ApplicationException() {
    }

    public ApplicationException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApplicationException(Integer code, String message,AppExceptionEnum exceptionEnum) {
        this.code = code;
        this.message = message;
        this.appExceptionEnum = exceptionEnum;
    }


    public ApplicationException(String message) {
        this.code = -1;
        this.message = message;
    }
    public ApplicationException(String message,AppExceptionEnum exceptionEnum) {
        this.code = -1;
        this.message = message;
        this.appExceptionEnum = exceptionEnum;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
