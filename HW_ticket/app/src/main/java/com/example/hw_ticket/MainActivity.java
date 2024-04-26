//a111222024 資科二甲 林郁旋

package com.example.hw_ticket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到 UI 元素
        Button button = (Button) findViewById(R.id.button);
        EditText edtQuantity = (EditText) findViewById(R.id.edtQuantity);
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 獲取購買數量
                int quantity;
                try {
                    quantity = Integer.parseInt(edtQuantity.getText().toString());
                } catch (NumberFormatException e) {
                    lblOutput.setText("請輸入有效的購買數量");
                    return;
                }

                if (quantity < 1) {
                    lblOutput.setText("購買數量應該至少為 1");
                    return;
                }

                // 獲取性別
                String gender = "";
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rdbBoy.isChecked()) {
                    gender = getResources().getString(R.string.male);
                } else if (rdbGirl.isChecked()) {
                    gender = getResources().getString(R.string.female);
                }

                // 獲取票券類型並計算總金額
                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);
                int ticketPrice = 0;

                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    ticketPrice = 500; // 全票
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    ticketPrice = 250; // 兒童票
                } else {
                    ticketPrice = 400; // 學生票
                }

                int totalAmount = ticketPrice * quantity;

                // 構建輸出字串
                String outputStr = gender + "\n";
                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket);
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket);
                } else {
                    outputStr += getResources().getString(R.string.studentticket);
                }

                outputStr += "\n購買數量: " + quantity;
                outputStr += "\n總金額: " + totalAmount;

                lblOutput.setText(outputStr);
            }
        });
    }
}