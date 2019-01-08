package com.yolo.service;

import com.yolo.entities.examples.CenterTemplate;
import com.yolo.models.base.MessageModel;


public interface CenterTemplateService {

    MessageModel add(CenterTemplate centerTemplate,String userId);

    MessageModel listAll();
}
