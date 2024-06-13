package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

enum State { FirstNumberInput, OperatorInputed, NumberInput }
enum OP { None, Add, Sub, Mul, Div }

public class MainActivity extends AppCompatActivity {

    private int theValue = 0;
    private int operand1 = 0, operand2 = 0;
    private OP op = OP.None;
    private State state = State.FirstNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        GridLayout keysGL = findViewById(R.id.keys);

        int kbHeight = keysGL.getHeight() / keysGL.getRowCount();
        int kbWidth = keysGL.getWidth() / keysGL.getColumnCount();

        Button btn;

        for (int i = 0; i < keysGL.getChildCount(); i++) {
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            btn.setTextSize(36);
        }
    }

    public void processKeyInput(View view) {
        Button b = (Button) view;
        String bstr = b.getText().toString();
        int bint;
        EditText edt = findViewById(R.id.display);

        switch (bstr) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                bint = Integer.parseInt(bstr);

                switch (state) {
                    case FirstNumberInput:
                        theValue = theValue * 10 + bint;
                        break;
                    case OperatorInputed:
                        theValue = bint;
                        operand2 = bint;
                        state = State.NumberInput;
                        break;
                    case NumberInput:
                        theValue = theValue * 10 + bint;
                        break;
                }
                edt.setText(String.valueOf(theValue));
                break;
            case "Clear":
                state = State.FirstNumberInput;
                theValue = 0;
                edt.setText("0");
                op = OP.None;
                operand2 = operand1 = 0;
                break;
            case "Back":
                theValue = theValue / 10;
                edt.setText(String.valueOf(theValue));
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                switch (state) {
                    case FirstNumberInput:
                        operand1 = theValue;
                        operand2 = theValue;
                        switch (bstr) {
                            case "+":
                                op = OP.Add;
                                break;
                            case "-":
                                op = OP.Sub;
                                break;
                            case "*":
                                op = OP.Mul;
                                break;
                            case "/":
                                op = OP.Div;
                                break;
                        }
                        state = State.OperatorInputed;
                        break;
                    case OperatorInputed:
                        switch (bstr) {
                            case "+":
                                op = OP.Add;
                                break;
                            case "-":
                                op = OP.Sub;
                                break;
                            case "*":
                                op = OP.Mul;
                                break;
                            case "/":
                                op = OP.Div;
                                break;
                        }
                        break;
                    case NumberInput:
                        switch (op) {
                            case Add:
                                operand1 += theValue;
                                break;
                            case Sub:
                                operand1 -= theValue;
                                break;
                            case Mul:
                                operand1 *= theValue;
                                break;
                            case Div:
                                if (theValue != 0) {
                                    operand1 /= theValue;
                                } else {
                                    // Handle division by zero error
                                    edt.setText("Error");
                                    return;
                                }
                                break;
                        }
                        edt.setText(String.valueOf(operand1));
                        operand2 = theValue;
                        state = State.OperatorInputed;
                        break;
                }
                break;
            case "=":
                switch (op) {
                    case None:
                        break;
                    case Add:
                        theValue = operand1 + operand2;
                        break;
                    case Sub:
                        theValue = operand1 - operand2;
                        break;
                    case Mul:
                        theValue = operand1 * operand2;
                        break;
                    case Div:
                        if (operand2 != 0) {
                            theValue = operand1 / operand2;
                        } else {
                            // Handle division by zero error
                            edt.setText("Error");
                            return;
                        }
                        break;
                }
                edt.setText(String.valueOf(theValue));
                state = State.FirstNumberInput;
                op = OP.None;
                operand1 = operand2 = 0;
                break;
        }
    }
}
