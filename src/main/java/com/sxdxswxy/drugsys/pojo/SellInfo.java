package com.sxdxswxy.drugsys.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SellInfo {

    private int sellId;

    private String sellName;

    private Double sellPrice;

    private Date sellDate;

    private int medId;

    private int userId;

}
