package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button buttonAdd;
    Button buttonDelete;
    Button buttonConfirm;
    EditText input;
    LinearLayout inputPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        input = findViewById(R.id.input);
        inputPanel = findViewById(R.id.inputPanel);


        String []cities = {"Edmonton"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.context, dataList);
        cityList.setAdapter(cityAdapter);

        buttonAdd.setOnClickListener(v ->  {
            inputPanel.setVisibility(View.VISIBLE);
            input.requestFocus();
        });
        buttonConfirm.setOnClickListener(v -> {
            String city = input.getText().toString();
            if (!city.isEmpty()) {
                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
                input.setText("");
                inputPanel.setVisibility(View.GONE);
            }
        });
        buttonDelete.setOnClickListener(v -> {
            if (!dataList.isEmpty()) {
                dataList.remove(dataList.size() - 1);
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}