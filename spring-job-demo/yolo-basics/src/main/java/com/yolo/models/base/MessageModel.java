package com.yolo.models.base;

import java.util.List;
import java.util.Map;

public interface MessageModel<T> extends ObjectModel<T> {

    MessageModel setCode(int var1);

    MessageModel setId(String var1);

    MessageModel setSuccess(boolean var1);

    MessageModel setMessage(String var1);

    MessageModel setError(String var1);

    MessageModel setObj(T var1);

    MessageModel setErrors(List<Map> var1);

    MessageModel setErrors(String var1, String var2);
}
