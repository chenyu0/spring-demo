package com.yolo.service;

import com.yolo.entities.Picture;
import com.yolo.models.base.MessageModel;


public interface PictureService {

    MessageModel add(Picture picture);

    MessageModel listAll();
}
