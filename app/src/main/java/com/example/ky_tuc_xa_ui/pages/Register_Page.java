package com.example.ky_tuc_xa_ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.ky_tuc_xa_ui.R;

public class Register_Page extends AppCompatActivity {
    private TextView btnTextLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        // Force light mode close dark mode default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        BtnTextLogin();
    }
    // end of onCreate

    private  void BtnTextLogin(){
        btnTextLogin = findViewById(R.id.id_textLogin);

        btnTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Page.this, Login_Page.class);
                startActivity(intent);
            }
        });
    }
}
