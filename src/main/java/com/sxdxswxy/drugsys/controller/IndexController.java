package com.sxdxswxy.drugsys.controller;

import com.sxdxswxy.drugsys.pojo.User;
import com.sxdxswxy.drugsys.service.UserService;
import com.sxdxswxy.drugsys.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("index")
    public String toIndex() {
        return "page/index";
    }

    @RequestMapping("manager")
    public String toIndexPage() {
        return "manager/index";
    }

    @RequestMapping("main")
    public String toMainPage() {
        return "manager/demo/welcome";
    }

    @RequestMapping("toLoginPage")
    public String toLoginPage() {
        return "page/signIn";
    }

    @RequestMapping("login")
    public String doLogin(String loginName,
                          String password, Model model,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        if ("".equals(loginName)) {
            model.addAttribute("msg", "登录名不能为空");
            return "page/signIn";
        }
        if ("".equals(password)) {
            model.addAttribute("msg", "密码不能为空");
            return "page/signIn";
        }

        User user = userServiceImpl.doLogin(loginName, password);
        if (user != null) {
            // 将用户登录信息加入cookie中
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30 * 60);

            session.setAttribute("user", user);
            Cookie c = new Cookie("JSESSIONID", session.getId());
            c.setMaxAge(60 * 30);
            response.addCookie(c);
            return "page/main";
        }

        model.addAttribute("msg", "登录名或密码错误");
        return "page/main";
    }

    @RequestMapping("toRegisterPage")
    public String toRegisterPage() {
        return "page/signUp";
    }

    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
        return "page/index";
    }

}
