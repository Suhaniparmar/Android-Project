package com.example.codesynctest.company;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codesynctest.R;

public class ResultAmazon extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_amazon);
        textView = (TextView)findViewById(R.id.percentage);
        textView.setText("You are prepared"+ AmazonAssessmentActivity.resultInPercentage + "% for applying to Google");
    }
}