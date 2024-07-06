package com.example.ky_tuc_xa_ui.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.ky_tuc_xa_ui.R;

public class Dash_board_page extends AppCompatActivity {

    private Spinner spinnerKhu;
    private Spinner spinnerCum;
    private Spinner spinnerNha;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board_page);

        // Force light mode close dark mode default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setUpAllDropDown();

    }
    // end of onCreate

    private void setUpAllDropDown() {
        // Set up "Chọn khu" dropdown
        spinnerKhu = findViewById(R.id.spinnerKhu);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chon_khu_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKhu.setAdapter(adapter);

        // Spinner item selected listener
        spinnerKhu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle selected item
                String selectedKhu = (String) parent.getItemAtPosition(position);
                Toast.makeText(Dash_board_page.this, "Selected: " + selectedKhu, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });

        // Set up "Chọn cụm" dropdown
        spinnerCum = findViewById(R.id.spinnerCum);
        ArrayAdapter<CharSequence> cumAdapter = ArrayAdapter.createFromResource(this,
                R.array.chon_cum_options, android.R.layout.simple_spinner_item);
        cumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCum.setAdapter(cumAdapter);

        // Set listeners if needed
        spinnerCum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCum = (String) parent.getItemAtPosition(position);
                showMessageToast(Dash_board_page.this,"selectedCum:"+selectedCum);
                // Handle further actions on selection if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });

        // Set up "Chọn nhà" dropdown
        spinnerNha = findViewById(R.id.spinnerNha);
        String[] nhaOptions = getResources().getStringArray(R.array.chon_nha_options);
        ArrayAdapter<String> nhaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nhaOptions);
        nhaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNha.setAdapter(nhaAdapter);

        // Spinner item selected listener for spinnerNha
        spinnerNha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedNha = (String) parent.getItemAtPosition(position);
                Toast.makeText(Dash_board_page.this, "Selected nhà: " + selectedNha, Toast.LENGTH_SHORT).show();
                // Handle further actions on selection if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });
    }


    private void showMessageToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
