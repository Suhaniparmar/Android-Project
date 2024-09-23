package com.example.codesynctest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AmazonAssessmentActivity extends AppCompatActivity {

    public static int result = 0, resultInPercentage;
    private Button submitButton;

    private EditText eDsa, ePss, eSd, ePlp, eOod;
    private EditText eVc, eDbms, eOs, eCnd, eTnd;
    private EditText eSs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_assessment);

        // Initialize EditText fields
        eDsa = findViewById(R.id.dsa);
        ePss = findViewById(R.id.pss);
        eSd = findViewById(R.id.sd);
        ePlp = findViewById(R.id.plp);
        eOod = findViewById(R.id.ood);

        eVc = findViewById(R.id.vc);
        eDbms = findViewById(R.id.dbms);
        eOs = findViewById(R.id.os);
        eCnd = findViewById(R.id.cnd);
        eTnd = findViewById(R.id.tnd);

        eSs = findViewById(R.id.ss);

        // Initialize the Submit button
        submitButton = findViewById(R.id.submitButton);

        // Set onClickListener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset result to 0 each time the button is clicked
                result = 0;

                try {
                    // Parse input from EditText fields and perform calculations
                    int resDsa = Integer.parseInt(eDsa.getText().toString()) * 10;
                    int resPss = Integer.parseInt(ePss.getText().toString()) * 9;
                    int resSd = Integer.parseInt(eSd.getText().toString()) * 8;
                    int resPlp = Integer.parseInt(ePlp.getText().toString()) * 6;
                    int resOod = Integer.parseInt(eOod.getText().toString()) * 7;

                    int resVc = Integer.parseInt(eVc.getText().toString()) * 6;
                    int resDbms = Integer.parseInt(eDbms.getText().toString()) * 9;
                    int resOs = Integer.parseInt(eOs.getText().toString()) * 8;
                    int resCnd = Integer.parseInt(eCnd.getText().toString()) * 7;
                    int resTnd = Integer.parseInt(eTnd.getText().toString()) * 7;

                    int resSs = Integer.parseInt(eSs.getText().toString()) * 5;

                    // Sum up the results
                    int[] sum = {resDsa, resPss, resSd, resPlp, resOod,
                            resVc, resDbms, resOs, resCnd, resTnd,
                            resSs};

                    for (int i = 0; i < sum.length; i++) {
                        result += sum[i];
                    }

                    // Calculate the result in percentage
                    resultInPercentage = (result * 100) / 634;
                    if(resultInPercentage>=100){
                        resultInPercentage=100;
                    }

                    // Show the final percentage result
                    //Toast.makeText(GoogleAssessmentActivity.this, "Your result: " + resultInPercentage + "%", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AmazonAssessmentActivity.this,ResultAmazon.class);
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    Toast.makeText(AmazonAssessmentActivity.this, "Please enter valid numbers in all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
