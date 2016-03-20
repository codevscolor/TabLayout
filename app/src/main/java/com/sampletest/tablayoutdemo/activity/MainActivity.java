package com.sampletest.tablayoutdemo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sampletest.tablayoutdemo.R;
import com.sampletest.tablayoutdemo.fragment.FragmentEight;
import com.sampletest.tablayoutdemo.fragment.FragmentFive;
import com.sampletest.tablayoutdemo.fragment.FragmentFour;
import com.sampletest.tablayoutdemo.fragment.FragmentOne;
import com.sampletest.tablayoutdemo.fragment.FragmentSeven;
import com.sampletest.tablayoutdemo.fragment.FragmentSix;
import com.sampletest.tablayoutdemo.fragment.FragmentThree;
import com.sampletest.tablayoutdemo.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //create one adapter , add fragments and set the adapter with viewpager
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "one");
        adapter.addFragment(new FragmentTwo(), "two");
        adapter.addFragment(new FragmentThree(), "three");
        adapter.addFragment(new FragmentFour(), "four");
        adapter.addFragment(new FragmentFive(), "five");
        adapter.addFragment(new FragmentSix(), "six");
        adapter.addFragment(new FragmentSeven(), "seven");
        adapter.addFragment(new FragmentEight(), "eight");
        viewPager.setAdapter(adapter);

        //setup tab layout with viewpager
        tabLayout.setupWithViewPager(viewPager);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
