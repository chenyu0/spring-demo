package com.yolo.service.impls;

import com.yolo.service.bizs.ExportPageBiz;
import com.yolo.service.export.ExportPageService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/31
 * Time: 14:15
 */

@Service
public class ExportPageServiceImpl implements ExportPageService {

    private ExportPageBiz exportPageBiz;

    @Override
    public String resolve2Page(Map paramsMap) {
        return exportPageBiz.resolve2Page(paramsMap);
    }
}
