package com.example.carlease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText leaseRate;
    EditText downPayment;
    EditText carValue;
    EditText months;
    Button goNext;
    float finalValue;
    float LR_VALUE;
    float DP_VALUE;
    float CV_VALUE;
    float MT_VALUE;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leaseRate = findViewById(R.id.leaseRate);
        downPayment = findViewById(R.id.downPayment);
        carValue = findViewById(R.id.carValue);
        months = findViewById(R.id.months);
        LR_VALUE = 0;
        DP_VALUE = 0;
        CV_VALUE = 0;
        MT_VALUE = 0;
        goNext = findViewById(R.id.goNext);
        i = new Intent(this,ValueActivity.class);
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MT_VALUE == 0){
                    System.out.println(LR_VALUE + " " + DP_VALUE + " " + CV_VALUE + " " + MT_VALUE);
                    System.out.println("clicked");
                    Toast.makeText(getApplicationContext(),"Enter all numbers", Toast.LENGTH_SHORT).show();
                } else {

                    finalValue = ((CV_VALUE - DP_VALUE)/MT_VALUE) + (((CV_VALUE - DP_VALUE)/MT_VALUE) * LR_VALUE);
                    i.putExtra("monthly_cost", finalValue);
                    startActivity(i);
                }
            }
        });
        leaseRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    LR_VALUE = Float.valueOf(charSequence.toString());
                }
                else {
                    LR_VALUE = 0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        downPayment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    DP_VALUE = Float.valueOf(charSequence.toString());
                }
                else {
                    DP_VALUE = 0;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        carValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    CV_VALUE = Float.valueOf(charSequence.toString());
                }
                else {
                    CV_VALUE = 0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        months.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    MT_VALUE = Float.valueOf(charSequence.toString());
                }
                else {
                    MT_VALUE = 0;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


    }
}