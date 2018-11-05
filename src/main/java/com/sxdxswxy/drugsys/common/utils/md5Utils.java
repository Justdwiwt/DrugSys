package com.sxdxswxy.drugsys.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * md5加密用户密码
 *
 * @author Justdwiwt
 */
public class md5Utils {

    /**
     * md5加密
     *
     * @param password pwd
     * @param username name
     * @return String
     */
    public static String getMd5HashPassword(String password, String username) {
        Md5Hash md5Hash = new Md5Hash(password, username, 3);
        return md5Hash.toString();
    }

}
