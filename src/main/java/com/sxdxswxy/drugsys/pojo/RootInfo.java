package com.sxdxswxy.drugsys.pojo;


public class RootInfo {

    private int rootId;
    private String rootNum;
    private int age;
    private char rootSex;
    private String rootEmail;
    private String rootPhone;

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getRootNum() {
        return rootNum;
    }

    public void setRootNum(String rootNum) {
        this.rootNum = rootNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getRootSex() {
        return rootSex;
    }

    public void setRootSex(char rootSex) {
        this.rootSex = rootSex;
    }

    public String getRootEmail() {
        return rootEmail;
    }

    public void setRootEmail(String rootEmail) {
        this.rootEmail = rootEmail;
    }

    public String getRootPhone() {
        return rootPhone;
    }

    public void setRootPhone(String rootPhone) {
        this.rootPhone = rootPhone;
    }

    @Override
    public String toString() {
        return "RootInfo{" +
                "rootId=" + rootId +
                ", rootNum='" + rootNum + '\'' +
                ", age=" + age +
                ", rootSex=" + rootSex +
                ", rootEmail='" + rootEmail + '\'' +
                ", rootPhone='" + rootPhone + '\'' +
                '}';
    }

}
