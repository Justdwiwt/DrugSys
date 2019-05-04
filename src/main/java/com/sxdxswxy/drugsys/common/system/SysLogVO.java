package com.sxdxswxy.drugsys.common.system;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class SysLogVO implements Serializable {
    private static final long serialVersionUID = -8969676638414748093L;
    private Integer id;

    private Integer userId;

    private String operDescription;

    private String remark;

    private String ip;

    private String createTime;

    private Integer sysId;

    private String userName;

    private String operLocation;

    private String realName;

    private String operModule;

    private String operMethod;

    private String reqTime;

    private String respTime;

    private Integer logLevel;

    private String logLevelName;

    private String sysCode;

    private String totalTime;

    private String reqQueryTime;

    private String respQueryTime;

    private String sysName;

    private String firstTime;

    private String lastTime;
}
