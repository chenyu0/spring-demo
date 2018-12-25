package com.yolo.controller;

import com.google.common.base.Preconditions;
import com.yolo.models.ParamException;
import com.yolo.models.base.MessageModel;
import com.yolo.service.FileService;
import com.yolo.utils.ParamUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:15
 */


@Controller
@RequestMapping("controller/FileController")
public class FileController extends BaseController {

    @Resource
    private FileService fileService;

    @RequestMapping("doUpload")
    public MessageModel doUpload() throws IOException, ServletException {

        Part part = this.getRequest().getPart("uploadFile");
        String name = part.getSubmittedFileName();
        InputStream inputStream = part.getInputStream();
        Preconditions.checkNotNull(inputStream, "传输文件不能为空");

        if (ParamUtil.isNullOrEmpty(inputStream.available()) || inputStream.available() > 1024 * 1024 * 10) {
            throw new ParamException(-1, "文件超过10M !!!");
        }

        return fileService.doUpload(inputStream, name);
    }

    @RequestMapping("delFile")
    public MessageModel delFile() {

        String fileKey = this.getParam("fileKey");

        if (ParamUtil.isNullOrEmpty(fileKey)) {
            throw new ParamException(-1, "传输参数不能为空 !!!");
        }

        return fileService.delFile(fileKey);
    }
}
