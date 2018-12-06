package com.yolo.models.base;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseMessage<T> extends BaseObjectModel<T> implements MessageModel<T> {

    private int code = 200;
    private String id;
    private String message = null;
    private Boolean success;
    private List<Map> errors = new ArrayList<>();
    private Map<String, Object> dto = new HashMap<>();

    public BaseMessage() {
    }

    public BaseMessage(String message) {
        this.message = message;
    }

    public BaseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseMessage(int code, String message, T obj) {
        this.code = code;
        this.message = message;
        super.setObj(obj);
    }

    public boolean getSuccess() {
        this.setSuccess(null == this.success ? this.getCode() == 200 || this.getCode() == 0 : this.success.booleanValue());
        return this.success;
    }

    //仅做序列化操作
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public boolean getFailed() {
        return !this.getSuccess();
    }

    public BaseMessage setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public List<Map> getErrors() {
        return this.errors;
    }

    public MessageModel toMessage() {
        return this;
    }

    public MessageModel toError() {
        this.setCode(590);
        this.success = false;
        return this;
    }

    public BaseMessage setErrors(List<Map> errors) {
        this.errors = errors;
        return this;
    }

    public BaseMessage setErrors(String id, String msg) {
        Map<String, String> field = new HashMap(2);
        field.put("id", id);
        field.put("msg", msg);
        this.getErrors().add(field);
        return this;
    }

    public String getId() {
        return this.id;
    }

    public BaseMessage setId(String id) {
        this.id = id;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public BaseMessage setCode(int code) {
        this.code = code;
        return this;
    }

    public BaseMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public BaseMessage setError(String message) {
        this.setCode(590);
        this.success = false;
        this.message = message;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public BaseMessage setObj(T obj) {
        super.setObj(obj);
        return this;
    }

    public Object getDTO(String name) {
        return this.dto.get(name);
    }

    public <K> K getDTO(String name, Class<K> clazz) {
        return clazz.cast(this.dto.get(name));
    }

    public BaseMessage setDTO(String name, Object value) {
        this.dto.put(name, value);
        return this;
    }
}
