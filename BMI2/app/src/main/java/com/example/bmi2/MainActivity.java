package com.example.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView txvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(edtHeight.getText().toString());
                double weight = Double.parseDouble(edtWeight.getText().toString());
                double bmi = weight / Math.pow(height/100.0 , 2);
                if (bmi >= 24) {
                    txvShow.setTextColor(Color.RED);
                    txvShow.setText(String.format("%.2f", bmi));
                }
                else if (bmi < 18.5 & bmi > 0) {
                    txvShow.setTextColor(Color.BLUE);
                    txvShow.setText(String.format("%.2f", bmi));
                } else if (height == 0 || weight== 0 ) {
                    txvShow.setTextColor(Color.BLACK);
                    txvShow.setText("身高或體重不可為零");
                } else {
                    txvShow.setTextColor(Color.GREEN);
                    txvShow.setText(String.format("%.2f", bmi));
                }


            }
        });
        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                edtHeight.setText("0");
                edtWeight.setText("0");
                txvShow.setText("");
            }
        });
    }

}