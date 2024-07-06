package com.example.ky_tuc_xa_ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.ky_tuc_xa_ui.MainActivity;
import com.example.ky_tuc_xa_ui.R;

public class Sp_page extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_page);

        // Force light mode close dark mode default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After the Sp_page duration, start the main activity
                Intent mainIntent = new Intent(Sp_page.this, Main_login_register_page.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);
    }
}
