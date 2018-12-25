package com.yolo.models;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:57
 */


public class ExcuteException extends ApplicationException {
    public ExcuteException() {
    }

    public ExcuteException(Integer code, String message) {
        super(code, message, AppExceptionEnum.ExcuteException);
    }

    public ExcuteException(String message) {
        super(message, AppExceptionEnum.ExcuteException);
    }

}
