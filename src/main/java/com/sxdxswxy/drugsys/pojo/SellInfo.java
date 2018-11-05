package com.sxdxswxy.drugsys.pojo;

import java.util.Date;

public class SellInfo {

    private int sellId;
    private String sellName;
    private Double sellPrice;
    private Date sellDate;
    private int medId;
    private int userId;

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SellInfo{" +
                "sellId=" + sellId +
                ", sellName='" + sellName + '\'' +
                ", sellPrice=" + sellPrice +
                ", sellDate=" + sellDate +
                ", medId=" + medId +
                ", userId=" + userId +
                '}';
    }

}
