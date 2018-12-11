package com.yolo.controller;

import com.yolo.entities.Picture;
import com.yolo.models.base.MessageModel;
import com.yolo.service.PictureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("controller/PictureController")
public class PictureController extends BaseController {

    @Resource
    private PictureService pictureService;


    @RequestMapping("add")
    public MessageModel add(Picture picture) {
        return pictureService.add(picture);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return pictureService.listAll();
    }
}
