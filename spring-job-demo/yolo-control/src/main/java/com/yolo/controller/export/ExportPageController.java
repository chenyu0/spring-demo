package com.yolo.controller.export;

import com.yolo.controller.BaseController;
import com.yolo.models.ParamException;
import com.yolo.service.export.ExportPageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/31
 * Time: 14:06
 */


@RestController
@RequestMapping("controller/export")
public class ExportPageController extends BaseController {

    @Resource
    private ExportPageService exportPageService;

    @RequestMapping("getPage")
    public String fileGetPage() {

        String type = this.getParam("type");

        switch (type) {
            case "data":
                return "forward:controller/SysTaskController/excute";
            case "page":
                return exportPageService.resolve2Page(this.getParamsMap());
            default:
                throw new ParamException("传输参数有误：type:" + type);
        }
    }


}
