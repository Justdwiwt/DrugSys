package com.sxdxswxy.drugsys.pojo;

import com.sxdxswxy.drugsys.common.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class Root extends BasePojo {

    private int rootId;

    private String rootName;

    private String rootPwd;

}
