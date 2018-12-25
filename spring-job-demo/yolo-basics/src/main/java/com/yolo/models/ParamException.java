package com.yolo.models;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:39
 */


public class ParamException extends ApplicationException {

    public ParamException() {
    }

    public ParamException(Integer code, String message) {
        super(code, message, AppExceptionEnum.ParamException);
    }

    public ParamException(String message) {
        super(message, AppExceptionEnum.ParamException);
    }

}
