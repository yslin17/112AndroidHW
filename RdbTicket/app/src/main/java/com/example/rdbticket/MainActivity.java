package com.example.rdbticket;
//A111222019

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtResult;
    EditText txtPiece;
    RadioGroup rgGender, rgType;
    String outputStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        txtPiece = findViewById(R.id.editTextNumber);
        RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
        RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
        RadioButton rdbAdult = (RadioButton) findViewById(R.id.rdbAdult);
        RadioButton rdbStudent = (RadioButton) findViewById(R.id.rdbStudent);
        RadioButton rdbChild = (RadioButton) findViewById(R.id.rdbChild);
        // 找到 RadioGroup
        rgGender = findViewById(R.id.rgGender);
        rgType = findViewById(R.id.rgType);

        // 為 RadioGroup 設置監聽器
        //rgGender.setOnCheckedChangeListener(radioGroupCheckedChangeListener);
        //rgType.setOnCheckedChangeListener(radioGroupCheckedChangeListener);
        Button button = (Button)findViewById(R.id.button);
        Button btnCheck = (Button)findViewById(R.id.btnCheck);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String outputStr = "";
                int price = 0;
                int outputPiece;

                outputPiece = Integer.parseInt(txtPiece.getText().toString());

                if (rdbBoy.isChecked() & rdbAdult.isChecked()){
                    outputStr += getResources().getString(R.string.male)+"\n";
                    outputStr += getResources().getString(R.string.regularticket);
                    price += 500;
                }
                else if (rdbBoy.isChecked() & rdbStudent.isChecked()){
                    outputStr += getResources().getString(R.string.male)+"\n";
                    outputStr += getResources().getString(R.string.studentticket);
                    price += 400;
                }
                else if (rdbBoy.isChecked() & rdbChild.isChecked()){
                    outputStr += getResources().getString(R.string.male)+"\n";
                    outputStr += getResources().getString(R.string.childticket);
                    price += 250;
                }
                else if (rdbGirl.isChecked() & rdbAdult.isChecked()){
                    outputStr += getResources().getString(R.string.female)+"\n";
                    outputStr += getResources().getString(R.string.regularticket);
                    price += 500;
                }
                else if (rdbGirl.isChecked() & rdbStudent.isChecked()){
                    outputStr += getResources().getString(R.string.female)+"\n";
                    outputStr += getResources().getString(R.string.studentticket);
                    price += 400;
                }
                else if (rdbGirl.isChecked() & rdbChild.isChecked()){
                    outputStr += getResources().getString(R.string.female)+"\n";
                    outputStr += getResources().getString(R.string.childticket);
                    price += 250;
                }

                outputStr += Integer.toString(outputPiece) + "張\n";
                outputStr += "金額 " + price * outputPiece + "元\n";
                txtResult.setText(outputStr);

            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("result", outputStr);
                startActivity(intent);
            }
        });
    }

}
