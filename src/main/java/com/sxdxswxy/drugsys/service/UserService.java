package com.sxdxswxy.drugsys.service;

import com.sxdxswxy.drugsys.pojo.User;

import javax.servlet.http.HttpServletRequest;


public interface UserService {

    User doLogin(String loginName, String password);

    String doRegister(HttpServletRequest request, String username, String password, String email);

}
