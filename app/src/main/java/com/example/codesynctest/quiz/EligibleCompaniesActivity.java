package com.example.codesynctest.quiz;

// File: EligibleCompaniesActivity.java


import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codesynctest.R;

public class EligibleCompaniesActivity extends AppCompatActivity {

    private static final String TAG = "EligibleCompaniesActivity";

    private TextView resultTitle;
    private ListView companiesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligible_companies);

        // Initialize views
        resultTitle = findViewById(R.id.result_title);
        companiesListView = findViewById(R.id.companies_list_view);

        // Retrieve eligible companies from intent
        String[] eligibleCompanies = getIntent().getStringArrayExtra("eligible_companies");

        if (eligibleCompanies != null && eligibleCompanies.length > 0) {
            Log.d(TAG, "Eligible Companies: " + String.join(", ", eligibleCompanies));

            // Set title based on the number of companies
            resultTitle.setText("You are eligible to apply at the following companies:");

            // Set up the ListView with eligible companies
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eligibleCompanies);
            companiesListView.setAdapter(adapter);
        } else {
            Log.d(TAG, "No eligible companies found.");

            // Set title to indicate no companies found
            resultTitle.setText("No eligible companies found based on your current skill set.");
        }
    }
}
