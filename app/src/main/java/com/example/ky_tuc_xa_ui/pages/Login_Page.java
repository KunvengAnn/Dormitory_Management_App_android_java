package com.example.ky_tuc_xa_ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.ky_tuc_xa_ui.MainActivity;
import com.example.ky_tuc_xa_ui.R;

public class Login_Page extends AppCompatActivity {
    private TextView textView_register;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        // Force light mode close dark mode default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        btnTextRegister();
        btnLogin();
    }
    // end of onCreate

    private void btnLogin(){
        btnLogin = findViewById(R.id.id_btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void btnTextRegister(){
        textView_register = findViewById(R.id.id_text_register);

        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Page.this, Register_Page.class);
                startActivity(intent);
            }
        });
    }
}
