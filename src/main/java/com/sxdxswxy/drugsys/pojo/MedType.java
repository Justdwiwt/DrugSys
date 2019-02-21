package com.sxdxswxy.drugsys.pojo;

import com.sxdxswxy.drugsys.common.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class MedType extends BasePojo {

    private int typeId;

    private String typeName;

    private String typeDesc;

}
