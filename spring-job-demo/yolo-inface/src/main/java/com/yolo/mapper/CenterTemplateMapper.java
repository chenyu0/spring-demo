package com.yolo.mapper;

import com.yolo.entities.examples.CenterTemplate;
import com.yolo.entities.examples.CenterTemplateExample;
import java.util.List;

public interface CenterTemplateMapper extends BasicMapper<CenterTemplate> {
    List<CenterTemplate> selectByExample(CenterTemplateExample example);
}