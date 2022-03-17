package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2,btn3, btn4, btn5,btn6, btn7, btn8,btn9, btnPlus, btnMinus,
            btnDiv, btnTimes, btnEquals, btnAC, btnDel, btnDot;

    private TextView textViewResult, textViewHistory;

    private String number = null;

    // Last number will always keep the last value printed on the screen.
    // After a new value is entered on the screen and operator is pressed,
    // values in lastNumber will be moved to firstNumber and new value of
    // lastNumber will be the numbers on  the screen.
    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    String history;
    String currentResult;
    boolean operator = false;
    boolean dot = true;
    boolean ACControl = true;
    boolean equalsControl = false;

    DecimalFormat Form = new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnTimes = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDivide);
        btnEquals = findViewById(R.id.btnEqual);
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.btnDot);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");

                if(operator){
                    if(status=="times"){
                        times();
                    }
                    else if(status=="divide"){
                        divide();
                    }
                    else if(status=="minus"){
                        minus();
                    }
                    else {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");

                if(operator){
                    if(status=="times"){
                        times();
                    }
                    else if(status=="divide"){
                        divide();
                    }
                    else if(status=="sum"){
                        plus();
                    }
                    else {
                        minus();
                    }
                }
                status = "minus";
                operator = false;
                number = null;
            }
        });

        btnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");

                if(operator){
                    if(status=="sum"){
                        plus();
                    }
                    else if(status=="divide"){
                        divide();
                    }
                    else if(status=="minus"){
                        minus();
                    }
                    else {
                        times();
                    }
                }
                status = "times";
                operator = false;
                number = null;

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");

                if(operator){
                    if(status=="sum"){
                        plus();
                    }
                    else if(status=="minus"){
                        minus();
                    }
                    else if(status=="times"){
                        times();
                    }
                    else {
                        divide();
                    }
                }
                status = "divide";
                operator = false;
                number = null;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator){
                    if(status=="sum"){
                        plus();
                    }
                    else if(status=="minus"){
                        minus();
                    }
                    else if(status=="times"){
                        times();
                    }
                    else if(status=="divide"){
                        divide();
                    }
                    else {
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
                equalsControl = true;
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                ACControl = true;
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dot){
                    if(number==null){
                        number = "0.";
                    }
                    else{
                        number = number + ".";
                    }
                }
                textViewResult.setText(number);
                dot = false;
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ACControl){
                    textViewResult.setText("0");
                }
                else{
                    number = number.substring(0,number.length()-1);

                    if(number.length()==0){
                        btnDel.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot  = false;
                    }
                    else {
                        dot = true;
                    }
                    textViewResult.setText(number);
                }
            }
        });

    }

    public void numberClick(String view){
        if(number==null){
            number = view;
        }
        else if(equalsControl){
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }
        else{
            number = number + view;

        }
        textViewResult.setText(number);
        operator = true;
        ACControl = false;
        btnDel.setClickable(true);
        equalsControl = false;
    }

    public void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber +  lastNumber;
        textViewResult.setText(Form.format(firstNumber));
        dot =true;
    }

    public void minus(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        textViewResult.setText(Form.format(firstNumber));
        dot = true;
    }

    public void times(){
        if(firstNumber==0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(Form.format(firstNumber));
        dot = true;
    }

    public void divide(){
        if(firstNumber==0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }
        else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber/lastNumber;
        }
        textViewResult.setText(Form.format(firstNumber));
        dot = true;

    }


}