package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yolo.models.ParamException;
import com.yolo.utils.ParamUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.IdUtil;
import com.yolo.entities.SysCenter;
import com.yolo.mapper.SysCenterMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class SysCenterBiz extends AdapterBiz {

    @Resource
    private SysCenterMapper sysCenterMapper;


    public Integer add(SysCenter sysCenter, String userId) {
        if (ParamUtil.isNullOrEmpty(sysCenter)
                || ParamUtil.isNullOrEmpty(sysCenter.getCenterCode())
                || ParamUtil.isNullOrEmpty(sysCenter.getCenterName())) {
            throw new ParamException("传输参数不可为空");
        }
        sysCenter.setId(IdUtil.uuid());

        sysCenter.setCreateTime(new Date());
        sysCenter.setUpdateTime(new Date());

        sysCenter.setCreateUser(userId);
        sysCenter.setUpdateUser(userId);

        return sysCenterMapper.insert(sysCenter);
    }

    public List<SysCenter> listAll() {
        return sysCenterMapper.selectList(null);
    }

    public IPage<SysCenter> listPage(int pageIndex,int pageSize) {
        IPage page = new Page(pageIndex,pageSize);

        QueryWrapper wrapper = new QueryWrapper();
        return sysCenterMapper.selectPage(page,wrapper);
    }
}
