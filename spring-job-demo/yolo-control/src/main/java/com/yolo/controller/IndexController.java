package com.yolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/5
 * Time: 20:08
 */

@Controller
public class IndexController extends BaseController {

    @RequestMapping("job_manager")
    public String index() {
        return "job_manager";
    }
}
