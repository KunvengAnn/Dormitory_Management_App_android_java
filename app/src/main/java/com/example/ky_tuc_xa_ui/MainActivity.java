package com.example.ky_tuc_xa_ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ky_tuc_xa_ui.pages.Cm_page;
import com.example.ky_tuc_xa_ui.pages.Dash_board_page;
import com.example.ky_tuc_xa_ui.pages.Main_login_register_page;
import com.example.ky_tuc_xa_ui.pages.Sp_page;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lt_CM;
    private LinearLayout lt_DashBoard;
    private LinearLayout lt_Student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allLinearItemNavigate();
    }
    // end of onCreate

    private void allLinearItemNavigate(){
        lt_CM = findViewById(R.id.id_linear_CM);
        lt_DashBoard = findViewById(R.id.id_linear_dashBoard);
        lt_Student = findViewById(R.id.id_linear_student);

        lt_CM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cm_page.class);
                startActivity(intent);
            }
        });

        lt_DashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dash_board_page.class);
                startActivity(intent);
            }
        });

        lt_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Dash_board_page.class);
//                startActivity(intent);
            }
        });
    }

}