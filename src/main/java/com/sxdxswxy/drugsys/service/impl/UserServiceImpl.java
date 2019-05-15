package com.sxdxswxy.drugsys.service.impl;

import com.sxdxswxy.drugsys.mapper.UserMapper;
import com.sxdxswxy.drugsys.pojo.User;
import com.sxdxswxy.drugsys.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    @Override
    public User doLogin(String loginName, String password) {
        User user = null;
        // 密码加密
        password = DigestUtils.md5Hex(password);
        user = userMapper.selectUserByEmailAndPwd(loginName, password);
        if (user == null) {
            user = userMapper.selectUserByNameAndPwd(loginName, password);
        }
        return user;
    }

    @Override
    public String doRegister(HttpServletRequest request, String username, String password, String email) {
        if (username == null || "".equals(username)) {
            return "用户名不能为空";
        }

        if (userMapper.selectUserByName(username) != null) {
            return "用户名已存在";
        }

        if (password == null || "".equals(password)) {
            return "密码不能为空";
        }

        if (email == null || "".equals(email)) {
            return "邮箱不能为空";
        }

        if (userMapper.selectUserByEmail(email) != null) {
            return "邮箱已存在";
        }

        //后台验证完成，然后将用户加入到数据库中
        User user = new User();
        user.setUserName(username);
        user.setUserPwd(DigestUtils.md5Hex(password));
//        user.setEmail(email);
        userMapper.insertUser(user);
        request.getSession().setAttribute("yzm", "qw5de5");
        return "";
    }


}
