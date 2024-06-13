package com.example.account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // 检查账号和密码是否正确
                if (username.equals("a111222024") && password.equals("1234abc")) {
                    // 登录成功
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    // 登录失败
                    Toast.makeText(MainActivity.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
