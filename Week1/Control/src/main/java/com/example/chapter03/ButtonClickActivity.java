package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.R;
import com.example.chapter03.util.DataUtil;

public class ButtonClickActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        tv_result = findViewById(R.id.tv_result);
        Button btn_clic_single=findViewById(R.id.btn_click_single);
        btn_clic_single.setOnClickListener(new MyViewOnClickListener(tv_result));

    }

    static class MyViewOnClickListener implements View.OnClickListener{

        private final TextView tv_result;

        public MyViewOnClickListener(TextView tv_result) {
            this.tv_result=tv_result;
        }

        @Override
        public void onClick(View v) {
            String desc=String.format("%s 您点击了按钮：%s", DataUtil.getNowTime(),((Button)v).getText());
            tv_result.setText(desc);
        }
    }
}