package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView prevEquation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        prevEquation = findViewById(R.id.previous_text_view);

    }
    private void newText(String strToAdd){
        String previousStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = previousStr.substring(0, cursorPos);
        String rightStr = previousStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }


    // button methods
    public void zeroBTN(View view){
        newText("0");

    }
    public void oneBTN(View view){
        newText("1");
    }
    public void twoBTN(View view){
        newText("2");
    }
    public void threeBTN(View view){
        newText("3");
    }
    public void fourBTN(View view){
        newText("4");
    }
    public void fiveBTN(View view){
        newText("5");
    }
    public void sixBTN(View view){
        newText("6");
    }
    public void sevenBTN(View view) {
        newText("7");
    }
    public void eightBTN(View view) {
        newText("8");
    }
    public void nineBTN(View view){
        newText("9");
    }
    public void clearBTN(View view){
        display.setText("");
        prevEquation.setText("");
    }
    public void expBTN(View view){
        newText("^");
    }
    public void openParBTN(View view){
        newText("(");
    }
    public void closedParBTN(View view){
        newText(")");
    }
    public void divideBTN(View view){
        newText("÷");
    }
    public void multiplyBTN(View view){
        newText("×");
    }
    public void subtractBTN(View view){
        newText("-");
    }
    public void addBTN(View view){
        newText("+");
    }
    public void equalsBTN(View view){
        String equation = display.getText().toString();
        equation = equation.replaceAll("×", "*");
        equation = equation.replaceAll("÷", "/");

        Expression exp = new Expression(equation);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

        prevEquation.setText(equation);
    }
    public void pointBTN(View view){
        newText(".");
    }
    public void negativeBTN(View view){
        newText("-");
    }

    public void exp2BTN(View view) { newText("e");};
    public void xSq(View view) { newText("^(2)"); };
    public void xCube(View view) { newText("^(3)"); };
    public void xPwy(View view) { newText("^("); };
    public void sqrt(View view) { newText("sqrt("); };
    public void log(View view) { newText("log("); };
    public void logN(View view) { newText("ln(");};
    public void sin(View view) { newText("sin("); };
    public void cos(View view) { newText("cos("); };
    public void tan(View view) { newText("tan("); };
    public void sinIn(View view) { newText("asin("); };
    public void cosIn(View view) { newText("acos("); };
    public void tanIn(View view) { newText("atan("); };

    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        if(cursorPos != 0 && textLength != 0){
            SpannableStringBuilder select = (SpannableStringBuilder) display.getText();
            select.replace(cursorPos -1, cursorPos, "");
            display.setText(select);
            display.setSelection(cursorPos - 1);
        }
    }

}