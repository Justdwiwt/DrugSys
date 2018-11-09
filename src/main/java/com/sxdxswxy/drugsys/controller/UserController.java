package com.sxdxswxy.drugsys.controller;

import com.sxdxswxy.drugsys.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public String getUser(@PathVariable int userId, Model model) {
        model.addAttribute("user", new UserInfo(userId, 20, '1', "1@1.com",
                "123450", "软件工程", "行知8"));
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            userInfoList.add(new UserInfo(i, 20 + i, '1', "1" + i + "@1.com",
                    "123450" + i, "软件工程", "行知8"));
        model.addAttribute("userInfos", userInfoList);
        return "/user/list";
    }

}
