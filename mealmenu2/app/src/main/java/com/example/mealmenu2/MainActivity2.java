package com.example.mealmenu2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView lblOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lblOutput = findViewById(R.id.lblOutput);

        // Get data from Intent extras
        String selectedMain = getIntent().getStringExtra("selectedMain");
        String selectedSide = getIntent().getStringExtra("selectedSide");
        String selectedDrinks = getIntent().getStringExtra("selectedDrinks");

        // Display the selected items in the TextView
        String outputText = "您選擇的餐點:\n主餐: " + selectedMain + "\n附餐: " + selectedSide + "\n飲料: " + selectedDrinks;
        lblOutput.setText(outputText);
    }
}
