package com.example.recruit.model;

public class Applicants extends People{
    private int id;
    private String name;
    private char sex;
    private String tel;
    //岗位名字
    private String postName;
    private String passWord;
    //简历情况
    private String condition;

    public Applicants() {
    }

    public Applicants(int id, String name, char sex, String tel, String postName, String passWord, String condition) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.postName = postName;
        this.passWord = passWord;
        this.condition = condition;
        this.tel=tel;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //填写个人信息
    @Override
    public void write() {

    }
}
