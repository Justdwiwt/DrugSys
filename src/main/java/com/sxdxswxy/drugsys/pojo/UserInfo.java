package com.sxdxswxy.drugsys.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {

    private int userId;
    private int userAge;
    private char userSex;
    private String userEmail;
    private String userPhone;
    private String userPro;
    private String userAddress;

    public UserInfo(int userId, int userAge, char userSex, String userEmail, String userPhone, String userPro, String userAddress) {
        this.userId = userId;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPro = userPro;
        this.userAddress = userAddress;
    }

}
