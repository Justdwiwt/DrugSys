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
        return "manager/demo/btn";
    }

    @RequestMapping("/toUserControll")
    public String toUserControll() {
        return "manager/demo/btn";
    }

    @RequestMapping("/toTypePage")
    public String toTypePage() {
        return "manager/demo/btn";
    }

    @RequestMapping("/toSellPage")
    public String toSellPage() {
        return "manager/demo/btn";
    }

    @RequestMapping("/toStoragePage")
    public String toStoragePage() {
        return "manager/demo/btn";
    }

    @RequestMapping("/toSellTotalPage")
    public String toSellTotalPage() {
        return "manager/demo/btn";
    }

    @RequestMapping("/toOtherTotalPage")
    public String toOtherTotalPage() {
        return "manager/demo/btn";
    }

}
