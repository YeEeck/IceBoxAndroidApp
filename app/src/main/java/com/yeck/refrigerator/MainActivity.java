package com.yeck.refrigerator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1024;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("智能冰箱");
        requestPermission();
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 先判断有没有权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                writeFile();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        } else {
            writeFile();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                writeFile();
            } else {
                Toast.makeText(MainActivity.this, "存储权限获取失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 模拟文件写入
     */
    private void writeFile() {
//        Toast.makeText(MainActivity.this, "写入文件成功", Toast.LENGTH_SHORT).show();
    }

    public void button_clicked(View view) {
        TextInputLayout usernameInput = findViewById(R.id.textInputLayout);
        TextInputLayout passwordInput = findViewById(R.id.textInputLayout2);
        if (Objects.requireNonNull(usernameInput.getEditText()).getText().toString().isEmpty() || Objects.requireNonNull(passwordInput.getEditText()).getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Main2Activity.class);
            try {
                //用MODE_PRIVAT模式，创建一个hxy.txt文件
                FileOutputStream outputStream = openFileOutput("user.txt", MODE_PRIVATE);
                //下面的就没么好说的了，写入方法和冲刷方法
                outputStream.write((usernameInput.getEditText().getText().toString() + " " + passwordInput.getEditText().getText().toString()).getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            intent.putExtra("username", usernameInput.getEditText().getText().toString());
            intent.putExtra("password", passwordInput.getEditText().getText().toString());
            startActivity(intent);
        }


    }
}
