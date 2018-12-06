package com.yolo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/5
 * Time: 20:08
 */

@RestController
public class IndexController extends BaseController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
