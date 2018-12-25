package com.yolo.service;

import com.yolo.models.base.MessageModel;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:23
 */


public interface FileService {
    MessageModel doUpload(InputStream inputStream, String fileName);

    MessageModel delFile(String fileKey);
}
