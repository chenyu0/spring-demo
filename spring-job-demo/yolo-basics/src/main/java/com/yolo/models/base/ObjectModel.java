package com.yolo.models.base;


public interface ObjectModel<T> extends BaseModel<T> {
    T getObj();

    BaseModel setObj(T obj);

    boolean hasObj();
}
