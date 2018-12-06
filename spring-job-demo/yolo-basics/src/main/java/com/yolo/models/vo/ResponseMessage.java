package com.yolo.models.vo;


import com.yolo.models.base.BaseMessage;

public class ResponseMessage<T> extends BaseMessage<T> {
    public ResponseMessage() {
    }

    public ResponseMessage(String message) {
        super(message);
    }

    public ResponseMessage(int code, String message) {
        super(code, message);
    }

    public ResponseMessage(int code, String message, T obj) {
        super(code, message, obj);
    }
}
