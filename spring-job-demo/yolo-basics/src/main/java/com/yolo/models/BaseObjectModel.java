package com.yolo.models;

import com.yolo.models.base.ObjectModel;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/9/28
 * Time: 9:37
 */


public class BaseObjectModel<T> implements ObjectModel<T> {
    private T obj = null;

    public BaseObjectModel() {
    }

    public T getObj() {
        return this.obj;
    }

    public ObjectModel setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public boolean hasObj() {
        return this.obj != null;
    }
}
