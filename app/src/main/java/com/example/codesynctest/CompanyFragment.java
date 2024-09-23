package com.example.codesynctest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CompanyFragment extends Fragment {

    private ListView companyListView;

    // Populate company list
    private ArrayList<Company> companyList = new ArrayList<>();
    private CompanyAdapter companyAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_company_fragment, container, false);



    // Initialize the ListView
    companyListView = view.findViewById(R.id.company_list_view);

        companyList.add(new Company("Google", R.drawable.google_icon));  // Google icon
        companyList.add(new Company("Amazon", R.drawable.amazon_icon));
        companyList.add(new Company("Facebook", R.drawable.facebook_icon));
        companyList.add(new Company("Apple", R.drawable.apple_icon));
        companyList.add(new Company("Microsoft", R.drawable.microsoft_icon));

    // Set up the adapter
    companyAdapter = new CompanyAdapter(getActivity(), companyList);
        companyListView.setAdapter(companyAdapter);

    // Set onItemClickListener for Google company
        companyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Start the assessment activity for Google
            // Example: Check if the user is logged in before redirecting to assessment activity
            if (position==0) {
                Log.d("CompanyFragment", "Google selected, starting assessment activity");
                Intent intent = new Intent(getActivity(), GoogleAssessmentActivity.class);
                startActivity(intent);
            } else if (position==1) {
                Log.d("CompanyFragment", "Amazon selected, starting assessment activity");
                Intent intent = new Intent(getActivity(), AmazonAssessmentActivity.class);
                startActivity(intent);

            } else {
                // Redirect to login if the user is not logged in
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(loginIntent);
                Log.d("CompanyFragment", "Different company selected");
            }

        }
    });

        return view;
}
}