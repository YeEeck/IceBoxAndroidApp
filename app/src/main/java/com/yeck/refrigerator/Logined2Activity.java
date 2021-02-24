package com.yeck.refrigerator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Logined2Activity extends AppCompatActivity {
    Intent inIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined2);
        inIntent = getIntent();
        TextView textView = findViewById(R.id.textView);
        String inner = "用户名:" + inIntent.getStringExtra("username") + "\n密码:" + inIntent.getStringExtra("password");
        textView.setText(inner);
    }
}
