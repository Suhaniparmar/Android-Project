package com.example.codesynctest;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.codesynctest.quiz.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("CodeSync");

        // Load the CompanyFragment
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new CompanyFragment())
//                    .commit();
//        }
//    }
//
//    // Handle the back button click
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed(); // Handle back navigation
//        return true;
//    }

    //btn = (Button)findViewById(R.id.button);


    ViewPager viewPager = findViewById(R.id.viewPager);
    TabLayout tabLayout = findViewById(R.id.tabLayout);

    // Set up your ViewPager with the custom adapter
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    int[] tabIcons = {R.drawable.ic_quiz,R.drawable.ic_company,R.drawable.ic_roadmap,R.drawable.ic_news,R.drawable.ic_user};
    // Set icons for the tabs
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
}

}