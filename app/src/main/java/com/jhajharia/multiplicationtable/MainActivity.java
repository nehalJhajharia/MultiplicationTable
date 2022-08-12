package com.jhajharia.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        generateTable(null);
    }

    public void setNum() {
        TextView input = findViewById(R.id.number);
        if (TextUtils.isEmpty(input.getText().toString())) {
            num = 2;
            return;
        }
        num = Integer.parseInt(input.getText().toString());
    }

    public void generateTable(View view) {
        setNum();

        ListView table = findViewById(R.id.table);
        ArrayList<String> tableContent = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            tableContent.add(num + " x " + i + " = " + (num * i));
        }

        ArrayAdapter<String> tableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableContent);
        table.setAdapter(tableAdapter);
    }
}