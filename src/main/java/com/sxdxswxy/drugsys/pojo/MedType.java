package com.sxdxswxy.drugsys.pojo;

import com.sxdxswxy.drugsys.common.pojo.BasePojo;

public class MedType extends BasePojo {

    private int typeId;
    private String typeName;
    private String typeDesc;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    @Override
    public String toString() {
        return "MedType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                '}';
    }

}
