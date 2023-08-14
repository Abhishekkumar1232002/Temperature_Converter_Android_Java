package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inputMain;
     TextView  outputC, outputF, outputK;
     Button buttonConvert;

     LinearLayout v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMain = findViewById(R.id.inputMain);
        outputC = findViewById(R.id.outputC);
        outputF = findViewById(R.id.outputF);
        outputK = findViewById(R.id.outputK);

        buttonConvert = findViewById(R.id.buttonConvert);

        v=(LinearLayout)findViewById(R.id.mainLayout);


        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCelsiusToFahrenheit();
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }


        });
    }
    private void convertCelsiusToFahrenheit() {
        String celsiusString = inputMain.getText().toString().trim();
        if (celsiusString.isEmpty()) {
            outputC.setText("Error");
            return;
        }

        else {
            double celsius = Double.parseDouble(celsiusString);
            double fahrenheit = (celsius * (1.8)) + 32;
            double kelvin = (celsius)+273.15;

            outputF.setText(String.format("%.2f",fahrenheit)+"°F");
            outputC.setText(String.format("%.2f",celsius)+"°C");
            outputK.setText(String.format("%.2f",kelvin)+"°K");
        }
    }
}