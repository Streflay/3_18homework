package com.example.recruit.model;

public class Boss extends People{

    private String tel;
    private String password;
    private String choose;//Boss决定是否招聘
    private String mes;//岗位发布信息

    public Boss() {
    }

    public Boss(String tel, String password, String choose, String mes) {
        this.tel = tel;
        this.password = password;
        this.choose = choose;
        this.mes=mes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    @Override
    //发布岗位信息、限定人数等
    public void write() {

    }
}
