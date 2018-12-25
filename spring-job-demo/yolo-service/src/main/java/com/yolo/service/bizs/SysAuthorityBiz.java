package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;

import com.yolo.entities.SysAuthority;
import com.yolo.mapper.SysAuthorityMapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SysAuthorityBiz extends AdapterBiz {

    @Resource
    private SysAuthorityMapper sysAuthorityMapper;


    public Integer add(SysAuthority sysAuthority) {
        return sysAuthorityMapper.insert(sysAuthority);
    }

    public List<SysAuthority> listAll() {
        return sysAuthorityMapper.selectList(null);
    }
}
