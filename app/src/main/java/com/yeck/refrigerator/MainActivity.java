package com.yeck.refrigerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("智能冰箱");
    }

    public void button_clicked(View view) {
        TextInputLayout usernameInput = findViewById(R.id.textInputLayout);
        TextInputLayout passwordInput = findViewById(R.id.textInputLayout2);
        if (Objects.requireNonNull(usernameInput.getEditText()).getText().toString().isEmpty() || Objects.requireNonNull(passwordInput.getEditText()).getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Logined2Activity.class);
            intent.putExtra("username", usernameInput.getEditText().getText().toString());
            intent.putExtra("password", passwordInput.getEditText().getText().toString());
            startActivity(intent);
        }


    }
}
