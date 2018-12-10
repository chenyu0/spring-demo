package com.yolo.service.impls;

import org.springframework.stereotype.Service;

import com.yolo.entities.Picture;
import com.yolo.models.base.MessageModel;
import com.yolo.service.PictureService;
import com.yolo.service.bizs.PictureBiz;

import javax.annotation.Resource;

@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureBiz pictureBiz;


    @Override
    public MessageModel add(Picture picture) {
        return pictureBiz.add(picture);
    }

    @Override
    public MessageModel listAll() {
        return pictureBiz.listAll();
    }
}
