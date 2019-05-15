package com.sxdxswxy.drugsys.mapper;

import com.sxdxswxy.drugsys.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserByName(@Param("userName") String userName);

    User selectUserByEmail(@Param("email") String email);

    User selectUserByNameAndPwd(@Param("userName") String userName, @Param("userPwd") String userPwd);

    User selectUserByEmailAndPwd(@Param("email") String email, @Param("userPwd") String userPwd);


    void insertUser(User user);

}
