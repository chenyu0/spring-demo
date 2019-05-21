package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yolo.entities.SysFile;
import com.yolo.mapper.SysFileMapper;
import com.yolo.models.ExcuteException;
import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.IdUtil;
import com.yolo.utils.ParamUtil;
import com.yolo.utils.TencentCloudFileUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:24
 */

@Repository
public class FileBiz extends AdapterBiz {

    @Resource
    private SysFileMapper sysFileMapper;

    public boolean doUpload(InputStream inputStream, boolean isLarge, String fileName) throws Exception {

        String url;
        if (isLarge) {
            url = TencentCloudFileUtil.instance().uploadLargeFile(inputStream, fileName);
        } else {
            url = TencentCloudFileUtil.instance().uploadSmallFile(inputStream, fileName);
        }

        if (ParamUtil.isNullOrEmpty(url)) {
            throw new ExcuteException(-1, "文件上传失败");
        }

        SysFile sysFile = new SysFile();
        sysFile.setId(IdUtil.uuid());
        sysFile.setFileUrl(url);
        sysFile.setFileName(fileName);
        sysFile.setCreateTime(new Date());
        sysFile.setUpdateTime(new Date());
        sysFile.setCreateUser("0");
        sysFile.setUpdateUser("0");

        return sysFileMapper.insert(sysFile) > 0;

    }

    public void delFile(String fileKey) {
        boolean delFile = TencentCloudFileUtil.instance().delFile(fileKey);
        if (delFile) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("file_url", "https://data-1257225728.cos.ap-shanghai.myqcloud.com/" + fileKey);
            sysFileMapper.delete(wrapper);
        }
    }

    public void download(){

    }
}
