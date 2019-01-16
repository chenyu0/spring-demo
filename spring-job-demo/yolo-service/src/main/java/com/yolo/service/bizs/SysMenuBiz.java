package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yolo.entities.SysMenu;
import com.yolo.mapper.SysMenuMapper;
import com.yolo.models.adapters.AdapterBiz;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SysMenuBiz extends AdapterBiz {

    @Resource
    private SysMenuMapper sysMenuMapper;

    public Integer add(SysMenu sysMenu) {

        return sysMenuMapper.insert(sysMenu);
    }

    public IPage<SysMenu> listPage(int pageSize, int pageIndex) {
        IPage page = new Page(pageIndex,pageSize);
        return sysMenuMapper.selectPage(page,null);
    }

    public List<SysMenu> listMenus(String userId) {
        return sysMenuMapper.selectMenusByUser(userId);
    }
}
