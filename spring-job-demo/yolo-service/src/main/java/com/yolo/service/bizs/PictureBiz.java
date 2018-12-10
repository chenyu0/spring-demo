package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;

import com.yolo.entities.Picture;
import com.yolo.models.base.MessageModel;
import com.yolo.models.ResponseMessage;
import com.yolo.mapper.PictureMapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PictureBiz extends AdapterBiz {

    @Resource
    private PictureMapper pictureMapper;


    public MessageModel add(Picture picture) {
        ResponseMessage response = new ResponseMessage();

        int insert = pictureMapper.insert(picture);

        if (insert > 0) {
            response.setMessage("插入失败！");
        } else {
            response.setMessage("插入成功！");
        }
        return response.setSuccess(true);
    }

    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        List select = pictureMapper.selectList(null);
        return response.setSuccess(true).setObj(select).toMessage();
    }
}
