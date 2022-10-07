package com.example.carlease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ValueActivity extends AppCompatActivity {
    TextView monthlyPayments;
    float value =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        Bundle extras = getIntent().getExtras();
        monthlyPayments = findViewById(R.id.MonthlyPayments);
        if (extras != null) {
            value = extras.getFloat("monthly_cost");
            String vv = String.valueOf(value);
            System.out.println("value " + vv);
            monthlyPayments.setText(vv);
        }


    }
}