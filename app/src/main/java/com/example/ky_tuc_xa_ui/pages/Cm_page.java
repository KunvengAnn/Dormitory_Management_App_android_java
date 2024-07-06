package com.example.ky_tuc_xa_ui.pages;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ky_tuc_xa_ui.R;
import com.example.ky_tuc_xa_ui.components.AdapterRecycler;
import com.example.ky_tuc_xa_ui.components.AdapterRecyclerTwo;

import java.util.ArrayList;
import java.util.List;

public class Cm_page extends AppCompatActivity {

    private RecyclerView recyclerViewOne;
    private RecyclerView recyclerViewTwo;
    private AdapterRecycler adapterRecycler;
    private AdapterRecyclerTwo adapterRecyclerTwo;

    private Spinner spinnerKhu;
    private Spinner spinnerCum;
    private EditText searchEditText_CmPage;

    private List<Integer> lsTextFloor;
    private List<Integer> filteredFloor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cm_page);

        // Force light mode close dark mode default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setUpAllDropDown();
        setupRecyclerViewOne();
        setupRecyclerViewTwo();

        setupSearchEditText();
    }
    // end of onCreate

    @SuppressLint("NotifyDataSetChanged")
    private void setupRecyclerViewOne() {
        recyclerViewOne = findViewById(R.id.id_recycler_1);
        recyclerViewOne.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> lsTitle = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lsTitle.add("A101-" + i);
        }
        adapterRecycler = new AdapterRecycler(Cm_page.this, lsTitle);
        recyclerViewOne.setAdapter(adapterRecycler);
        adapterRecycler.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setupRecyclerViewTwo() {
        recyclerViewTwo = findViewById(R.id.id_recycler_2);
        recyclerViewTwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        lsTextFloor = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lsTextFloor.add(i);
        }
        filteredFloor = new ArrayList<>(lsTextFloor);
        adapterRecyclerTwo = new AdapterRecyclerTwo(Cm_page.this, filteredFloor);
        recyclerViewTwo.setAdapter(adapterRecyclerTwo);
        adapterRecyclerTwo.notifyDataSetChanged();
    }

    private void setupSearchEditText() {
        searchEditText_CmPage = findViewById(R.id.searchEditText_CmPage);
        searchEditText_CmPage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterRecyclerViewTwo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void filterRecyclerViewTwo(String query) {
        filteredFloor.clear();
        if (query.isEmpty()) {
            filteredFloor.addAll(lsTextFloor);
        } else {
            try {
                int floor = Integer.parseInt(query);
                for (int number : lsTextFloor) {
                    if (number == floor) {
                        filteredFloor.add(number);
                    }
                }
            } catch (NumberFormatException e) {
                // Handle the exception if the input is not a valid number
                Toast.makeText(this, "Invalid floor number", Toast.LENGTH_SHORT).show();
            }
        }
        adapterRecyclerTwo.notifyDataSetChanged();
    }


    private void setUpAllDropDown() {
        // Set up "Chọn khu" dropdown
        spinnerKhu = findViewById(R.id.spinnerKhu_Cm);

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
                Toast.makeText(Cm_page.this, "Selected: " + selectedKhu, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });

        // Set up "Chọn cụm" dropdown
        spinnerCum = findViewById(R.id.spinnerCum_Cm);
        ArrayAdapter<CharSequence> cumAdapter = ArrayAdapter.createFromResource(this,
                R.array.chon_cum_options, android.R.layout.simple_spinner_item);
        cumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCum.setAdapter(cumAdapter);

        // Set listeners if needed
        spinnerCum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCum = (String) parent.getItemAtPosition(position);

                // Handle further actions on selection if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });
    }
}
