package com.sxdxswxy.drugsys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

//    @RequestMapping("/login")
//    public String login(@Valid LoginParam loginParam, BindingResult result, ModelMap model, HttpServletRequest request) {
//        String errorMsg = "";
//        if (result.hasErrors()) {
//            List<ObjectError> list = result.getAllErrors();
//            for (ObjectError error : list) {
//                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
//            }
//            model.addAttribute("errorMsg", errorMsg);
//            return "login";
//        }
//        UserEntity user = userRepository.findByUserName(loginParam.getLoginName());
//        if (user == null) {
//            user = userRepository.findByEmail(loginParam.getLoginName());
//        }
//        if (user == null) {
//            model.addAttribute("errorMsg", "用户名不存在!");
//            return "login";
//        } else if (!user.getPassword().equals(loginParam.getPassword())) {
//            model.addAttribute("errorMsg", "密码错误！");
//            return "login";
//        }
//
//        request.getSession().setAttribute(WebConfiguration.LOGIN_KEY, user.getId());
//        request.getSession().setAttribute(WebConfiguration.LOGIN_USER, user);
//        return "redirect:/list";
//    }
//
//    @RequestMapping("/register")
//    public String register(@Valid RegisterParam registerParam, BindingResult result, ModelMap model) {
//        logger.info("register param" + registerParam.toString());
//        String errorMsg = "";
//        if (result.hasErrors()) {
//            List<ObjectError> list = result.getAllErrors();
//            for (ObjectError error : list) {
//                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
//            }
//            model.addAttribute("errorMsg", errorMsg);
//            return "register";
//        }
//        UserEntity u = userRepository.findByUserNameOrEmail(registerParam.getUserName(), registerParam.getEmail());
//        if (u != null) {
//            model.addAttribute("errorMsg", "用户已存在!");
//            return "register";
//        }
//        UserEntity user = new UserEntity();
//        BeanUtils.copyProperties(registerParam, user);
//        user.setRegTime(new Date());
//        user.setUserType("manage");
//        user.setState("unverified");
//        userRepository.save(user);
//        logger.info("register user " + user.toString());
//        return "login";
//    }
//
//    @RequestMapping("/loginOut")
//    public String loginOut(HttpServletRequest request) {
//        request.getSession().removeAttribute(WebConfiguration.LOGIN_KEY);
//        request.getSession().removeAttribute(WebConfiguration.LOGIN_USER);
//        return "login";
//    }

}
