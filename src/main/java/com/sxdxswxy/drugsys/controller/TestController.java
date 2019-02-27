package com.sxdxswxy.drugsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 单例测试
 *
 * @author Justdwiwt
 */
@Controller
public class TestController {

    /**
     * 测试页面跳转
     *
     * @return testPath
     */
    @RequestMapping(value = "/title", method = RequestMethod.GET)
    public String testPage() {
        return "/common/title";
    }

}

