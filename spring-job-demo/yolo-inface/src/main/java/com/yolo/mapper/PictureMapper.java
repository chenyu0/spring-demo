package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.Picture;
import com.yolo.entities.PictureExample;
import java.util.List;

public interface PictureMapper extends BaseMapper {
    List<Picture> selectByExample(PictureExample example);
}