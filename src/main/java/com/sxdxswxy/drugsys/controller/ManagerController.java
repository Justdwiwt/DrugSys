package com.sxdxswxy.drugsys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/toUserMsgPage")
    public String toUserMsgPage() {
        return "demo/btn";
    }

    @RequestMapping("/toUserControll")
    public String toUserControll() {
        return "demo/btn";
    }

    @RequestMapping("/toTypePage")
    public String toTypePage() {
        return "demo/btn";
    }

    @RequestMapping("/toSellPage")
    public String toSellPage() {
        return "demo/btn";
    }

    @RequestMapping("/toStoragePage")
    public String toStoragePage() {
        return "demo/btn";
    }

    @RequestMapping("/toSellTotalPage")
    public String toSellTotalPage() {
        return "demo/btn";
    }

    @RequestMapping("/toOtherTotalPage")
    public String toOtherTotalPage() {
        return "demo/btn";
    }

}
