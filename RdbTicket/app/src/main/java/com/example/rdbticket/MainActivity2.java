package com.example.rdbticket;

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
        String all;
        String a = getResources().getString(R.string.detail)+"\n";
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        TextView textView = (TextView) findViewById(R.id.textView4);
        String result = getIntent().getStringExtra("result");
        all = a+result;
        textView.setText(all);
    }
}