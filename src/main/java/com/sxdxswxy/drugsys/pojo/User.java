package com.sxdxswxy.drugsys.pojo;

import com.sxdxswxy.drugsys.common.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class User extends BasePojo {

    private int userId;

    private String userName;

    private String userPwd;

    private String userNum;

}
