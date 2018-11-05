package com.sxdxswxy.drugsys.controller;

import com.sxdxswxy.drugsys.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", new User(id, "name0", 20, '1',
                2015330200, "软件工程", "行知8"));
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            userList.add(new User(i, "name" + i, 20 + i, '1',
                    201533020 + i, "软件工程", "行知8"));
        model.addAttribute("users", userList);
        return "/user/list";
    }

}
