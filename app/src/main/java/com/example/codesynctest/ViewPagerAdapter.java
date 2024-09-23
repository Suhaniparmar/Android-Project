package com.example.codesynctest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new QuizFragment();       // Skill Assessment Quizzes
            case 1:
                return new CompanyFragment();    // Company-Specific Insights
            case 2:
                return new RoadmapFragment();    // Career Roadmaps
            case 3:
                return new NewsFragment();       // Industry Trends and News
            case 4:
                return new UserFragment();       // User Details
            default:
                return new QuizFragment();
        }
    }

    @Override
    public int getCount() {
        return 5; // 5 tabs
    }
}

