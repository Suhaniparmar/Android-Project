package com.example.codesynctest.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.example.codesynctest.R;

import java.util.ArrayList;

public class CompanyAdapter extends ArrayAdapter<Company> {

    public CompanyAdapter(Context context, ArrayList<Company> companies) {
        super(context, 0, companies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the company item for this position
        Company company = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.company_item, parent, false);
        }

        // Lookup view for data population
        ImageView companyIcon = convertView.findViewById(R.id.company_icon);
        TextView companyName = convertView.findViewById(R.id.company_name);

        // Populate the data into the template view
        companyIcon.setImageResource(company.getCompanyImage());
        companyName.setText(company.getCompanyName());

        // Return the completed view to render on screen
        return convertView;
    }
}
