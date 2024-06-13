package com.example.mealmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        TextView lblOutput = findViewById(R.id.lblOutput);


        Intent intent = getIntent();
        String selectedMain = intent.getStringExtra("selectedMain");
        String selectedSide = intent.getStringExtra("selectedSide");
        String selectedDrinks = intent.getStringExtra("selectedDrinks");


        String output = "主餐: " + selectedMain + "\n附餐: " + selectedSide + "\n飲料: " + selectedDrinks;
        lblOutput.setText(output);
    }
}