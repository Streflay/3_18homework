package com.example.recruit.model;

public class HR extends People{
    private int id;
    private String postName;
    private char sex;
    private String tel;
    private String name;
    private String passWord;
    //评价
    private String command;
    //选择推送或者退回
    private String choose;

    public HR() {
    }

    public HR(int id, String postName,char sex, String tel, String name,String passWord, String command, String choose) {
        this.id = id;
        this.postName = postName;
        this.sex=sex;
        this.tel = tel;
        this.name = name;
        this.passWord=passWord;
        this.command = command;
        this.choose = choose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    //人物评价
    public void write() {

    }
}
