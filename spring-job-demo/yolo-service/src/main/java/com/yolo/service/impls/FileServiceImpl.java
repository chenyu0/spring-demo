package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.models.base.MessageModel;
import com.yolo.service.FileService;
import com.yolo.service.bizs.FileBiz;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:23
 */

@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileBiz fileBiz;

    @Override
    public MessageModel doUpload(InputStream inputStream, String fileName) {
        ResponseMessage response = new ResponseMessage();
        try {
            if (inputStream.available() > 1024 * 1024 * 10) {
                fileBiz.doUpload(inputStream, true,fileName);
            } else {
                fileBiz.doUpload(inputStream, false,fileName);
            }
            response.setSuccess(true).setMessage("保存成功");
        } catch (Exception e) {
            LogUtil.error("保存失败："+e.getMessage());
            response.setSuccess(false).setMessage("保存失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel delFile(String fileKey) {
        ResponseMessage response = new ResponseMessage();
        try {
            fileBiz.delFile(fileKey);
            response.setSuccess(false).setMessage("删除成功!");
        }catch (Exception e){
            LogUtil.error("删除失败："+e.getMessage());
            response.setSuccess(false).setMessage("删除失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
