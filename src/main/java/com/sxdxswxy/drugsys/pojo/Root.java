package com.sxdxswxy.drugsys.pojo;

import com.sxdxswxy.drugsys.common.pojo.BasePojo;

public class Root extends BasePojo {

    private int rootId;
    private String rootName;
    private String rootPwd;

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getRootPwd() {
        return rootPwd;
    }

    public void setRootPwd(String rootPwd) {
        this.rootPwd = rootPwd;
    }

    @Override
    public String toString() {
        return "Root{" +
                "rootId=" + rootId +
                ", rootName='" + rootName + '\'' +
                ", rootPwd='" + rootPwd + '\'' +
                '}';
    }

}
