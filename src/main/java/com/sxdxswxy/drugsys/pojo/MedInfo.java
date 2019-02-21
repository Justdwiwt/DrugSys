package com.sxdxswxy.drugsys.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MedInfo {

    private int medId;

    private String medNum;

    private String medName;

    private String medFactory;

    private String medDesc;

    private Double medPrice;

    private int medCount;

    private String medPic;

    private int typeId;

}
