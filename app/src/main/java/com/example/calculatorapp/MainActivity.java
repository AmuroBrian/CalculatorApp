package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button ACButton, signButton, divButton, mulButton, minusButton, plusButton, decButton, equalButton, percentButton;
    Button zero,one,two,three,four,five,six,seven,eight,nine;
    Button[] numButton = new Button[10];
    TextView resultField;
    String result = "";
    double num1 = 0;
    char op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = (TextView) findViewById(R.id.resultfield);
        ACButton = (Button) findViewById(R.id.acbutton);
        signButton = (Button) findViewById(R.id.signbutton);
        divButton = (Button) findViewById(R.id.divbutton);
        mulButton = (Button) findViewById(R.id.mulbutton);
        minusButton = (Button) findViewById(R.id.minusbutton);
        plusButton = (Button) findViewById(R.id.plusbutton);
        decButton = (Button) findViewById(R.id.decbutton);
        equalButton = (Button) findViewById(R.id.equalbutton);
        percentButton = (Button) findViewById(R.id.percentbutton);
        numButton[0] = (Button) findViewById(R.id.zero);
        numButton[1] = (Button) findViewById(R.id.one);
        numButton[2] = (Button) findViewById(R.id.two);
        numButton[3] = (Button) findViewById(R.id.three);
        numButton[4] = (Button) findViewById(R.id.four);
        numButton[5] = (Button) findViewById(R.id.five);
        numButton[6] = (Button) findViewById(R.id.six);
        numButton[7] = (Button) findViewById(R.id.seven);
        numButton[8] = (Button) findViewById(R.id.eight);
        numButton[9] = (Button) findViewById(R.id.nine);

        for (Button i : numButton){
            i.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (i == numButton[0]){
                        result += "0";
                        resultField.setText(result);
                    } else if (i == numButton[1]){
                        result += "1";
                        resultField.setText(result);
                    } else if (i == numButton[2]){
                        result += "2";
                        resultField.setText(result);
                    } else if (i == numButton[3]){
                        result += "3";
                        resultField.setText(result);
                    } else if (i == numButton[4]){
                        result += "4";
                        resultField.setText(result);
                    } else if (i == numButton[5]){
                        result += "5";
                        resultField.setText(result);
                    } else if (i == numButton[6]){
                        result += "6";
                        resultField.setText(result);
                    } else if (i == numButton[7]){
                        result += "7";
                        resultField.setText(result);
                    } else if (i == numButton[8]){
                        result += "8";
                        resultField.setText(result);
                    } else if (i == numButton[9]){
                        result += "9";
                        resultField.setText(result);
                    }
                }
            });

            decButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!result.contains(".")){
                        result += ".";
                        resultField.setText(result);
                    }
                }
            });

            ACButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result = "";
                    resultField.setText("0");
                }
            });

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    result = "";
                    resultField.setText("0");
                    op = '+';
                }
            });

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    result = "";
                    resultField.setText("0");
                    op = '-';
                }
            });

            mulButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    result = "";
                    resultField.setText("0");
                    op = '*';
                }
            });

            divButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    result = "";
                    resultField.setText("0");
                    op = '/';
                }
            });

            percentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    num1 = num1/100;
                    result = "";
                    resultField.setText(String.valueOf(num1));
                    op = '%';
                }
            });

            signButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(resultField.getText().toString());
                    num1 = num1 - 2 * num1;
                    result = "";
                    resultField.setText(String.valueOf(num1));
                }
            });

            equalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (op){
                        case '+':
                            num1 += Double.parseDouble(resultField.getText().toString());
                            break;
                        case '-':
                            num1 -= Double.parseDouble(resultField.getText().toString());
                            break;
                        case '*':
                            num1 *= Double.parseDouble(resultField.getText().toString());
                            break;
                        case '/':
                            num1 /= Double.parseDouble(resultField.getText().toString());
                            break;
                    }
                    String result = Double.toString(num1);
                    if (result.length() > 8){
                        result = String.format("%.2f", num1);
                        resultField.setText(result);
                    } else {
                        if (result.matches("([0-9]*).(0)")){
                            result = String.format("%d", (int) num1);
                            resultField.setText(result);
                        } else {
                            resultField.setText(result);
                        }
                    }

                    num1 = 0;
                }
            });
        }
    }
}