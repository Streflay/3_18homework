package com.example.recruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recruit.model.DBAdapter;

public class MainActivity extends AppCompatActivity implements IView{
    EditText tel, pwd;
    Button btnlogin, btnreg;
    private DBAdapter DBhelper;
//    SQLiteDatabase db;
//    SharedPreferences sp1,sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBhelper=new DBAdapter(this);
        DBhelper.open();
        tel = findViewById(R.id.tel);  //用户名输入框
        pwd = findViewById(R.id.pwd);   //密码输入框
        btnlogin = findViewById(R.id.login);  //登录按钮
        btnreg = findViewById(R.id.reg);   //注册按钮

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Register.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "前往注册", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public String getUserMobile() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void toActivity() {

    }

    @Override
    public void loginSucess() {

    }

    @Override
    public void loginFailure() {

    }
}

