package com.sxdxswxy.drugsys.pojo;

public class User {

    private int id;
    private String name;
    private int age;
    private char sex;
    private int number;
    private String proClass;
    private String address;

    public User(int id, String name, int age, char sex, int number, String proClass, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.number = number;
        this.proClass = proClass;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", number=" + number +
                ", proClass='" + proClass + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
