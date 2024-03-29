package com.example.recruit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recruit.model.Applicants;
import com.example.recruit.model.Boss;
import com.example.recruit.model.HR;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    EditText usertel,usepwd,userpwd2;
    Button submit;
    MySql mySql;
    SQLiteDatabase db;
    private static int aid=0;//打工人人数
    private static int hid=0;//HR人数
    private static int bid=0;//Boss人数只能有一个

    SharedPreferences sp;
    List<Applicants> applicants=new ArrayList<>();
    List<Boss> bosses=new ArrayList<>();
    List<HR> hrs=new ArrayList<>();
    private String[] location=new String[]{"打工人","HR","Boss"};
    private String selectedItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //获取身份
        Spinner spinner=findViewById(R.id.spinner);
        //注册电话号和密码
        usertel=findViewById(R.id.usertel);
        usepwd=findViewById(R.id.usepwd);
        userpwd2=findViewById(R.id.usepwd2);
        submit=findViewById(R.id.submit);
        mySql=new MySql(this,"userinfo",null,1);
        db=mySql.getReadableDatabase();
        sp=this.getSharedPreferences("userinfo",MODE_PRIVATE);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem=adapterView.getItemAtPosition(i).toString();
                if (selectedItem.equals("打工人")){
                    Applicants a=new Applicants();
                    aid++;
                    a.setId(aid);
                    applicants.add(a);
                }else if (selectedItem.equals("HR")){
                    HR h=new HR();
                    hid++;
                    h.setId(hid);
                    hrs.add(h);
                }else {
                    if(bid==0){
                    Boss b=new Boss();
                    bosses.add(b);
                    bid++;
                }else {
                        Toast.makeText(Register.this,"已经有老板了",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                 Toast.makeText(Register.this,"您未选择您的身份",Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            boolean flag=true;
            @Override
            public void onClick(View view) {

                String name=usertel.getText().toString();  //用户名
                String pwd01=usepwd.getText().toString();   //密码
                String pwd02=userpwd2.getText().toString();   //二次输入的密码

                if (name.equals("")||pwd01.equals("")||pwd02.equals("")){
                    Toast.makeText(Register.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                } else if (selectedItem.equals("")) {
                    Toast.makeText(Register.this,"您未选择您的身份",Toast.LENGTH_SHORT).show();
                } else {
//                    Cursor cursor = db.query("logins", new String[]{"username"}, null, null, null, null, null);
//                    while (cursor.moveToNext()) {
//                        if (cursor.getString(0).equals(name)) {
//                            flag = false;
//                            break;
//                        }
                    }
                    if (flag == true) {
                        if (pwd01.equals(pwd02)) {

                            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setClass(Register.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "密码不一致", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "用户已存在", Toast.LENGTH_LONG).show();
                    }
                }
                }
        });
    }
}
