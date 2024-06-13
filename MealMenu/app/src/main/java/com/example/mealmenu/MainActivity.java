package com.example.mealmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner chooseMeal;
    private ListView listView;
    private TextView lblMain, lblSide, lblDrinks;

    private ArrayAdapter<String> mainAdapter, sideAdapter, drinksAdapter;
    private String[] mainMeals = {"牛肉漢堡", "豬肉漢堡", "炸雞漢堡", "炸魚漢堡"};
    private String[] sideMeals = {"薯條", "沙拉", "玉米濃湯", "蘋果派"};
    private String[] drinks = {"可樂", "雪碧", "冰紅茶"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        chooseMeal = findViewById(R.id.ChooseMeal);
        listView = findViewById(R.id.listview);
        lblMain = findViewById(R.id.lblMain);
        lblSide = findViewById(R.id.lblSide);
        lblDrinks = findViewById(R.id.lblDrinks);

        String[] categories = {"主餐", "附餐", "飲料"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseMeal.setAdapter(spinnerAdapter);

        mainAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainMeals);
        sideAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sideMeals);
        drinksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drinks);

        chooseMeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        listView.setAdapter(mainAdapter);
                        break;
                    case 1:
                        listView.setAdapter(sideAdapter);
                        break;
                    case 2:
                        listView.setAdapter(drinksAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                switch (chooseMeal.getSelectedItemPosition()) {
                    case 0:
                        lblMain.setText(selectedItem);
                        break;
                    case 1:
                        lblSide.setText(selectedItem);
                        break;
                    case 2:
                        lblDrinks.setText(selectedItem);
                        break;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView output1 = (TextView) findViewById(R.id.lblMain);
        TextView output2 = (TextView) findViewById(R.id.lblSide);
        TextView output3 = (TextView) findViewById(R.id.lblDrinks);
        int itemId = item.getItemId();
        if(itemId == R.id.finish){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("selectedMain", output1.getText().toString());
            intent.putExtra("selectedSide", output2.getText().toString());
            intent.putExtra("selectedDrinks", output3.getText().toString());
            startActivity(intent);
        } else if (itemId == R.id.clear) {
            output1.setText("請選擇");
            output2.setText("請選擇");
            output3.setText("請選擇");
        }
        return super.onOptionsItemSelected(item);
    }
}