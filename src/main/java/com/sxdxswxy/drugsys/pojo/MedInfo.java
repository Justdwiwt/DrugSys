package com.sxdxswxy.drugsys.pojo;

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

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public String getMedNum() {
        return medNum;
    }

    public void setMedNum(String medNum) {
        this.medNum = medNum;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedFactory() {
        return medFactory;
    }

    public void setMedFactory(String medFactory) {
        this.medFactory = medFactory;
    }

    public String getMedDesc() {
        return medDesc;
    }

    public void setMedDesc(String medDesc) {
        this.medDesc = medDesc;
    }

    public Double getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(Double medPrice) {
        this.medPrice = medPrice;
    }

    public int getMedCount() {
        return medCount;
    }

    public void setMedCount(int medCount) {
        this.medCount = medCount;
    }

    public String getMedPic() {
        return medPic;
    }

    public void setMedPic(String medPic) {
        this.medPic = medPic;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "MedInfo{" +
                "medId=" + medId +
                ", medNum='" + medNum + '\'' +
                ", medName='" + medName + '\'' +
                ", medFactory='" + medFactory + '\'' +
                ", medDesc='" + medDesc + '\'' +
                ", medPrice=" + medPrice +
                ", medCount=" + medCount +
                ", medPic='" + medPic + '\'' +
                ", typeId=" + typeId +
                '}';
    }

}
