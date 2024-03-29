package com.example.recruit;


//登录界面接口
public interface IView {
    //获取电话号码
    String getUserMobile();
    //获取密码
    String getUserPassword();
    //展示登录进程
    void showProgress();
    //隐藏进程
    void hideProgress();
    //跳转页面
    void toActivity();
    //登录成功
    void loginSucess();
    //登录失败
    void loginFailure();


}
