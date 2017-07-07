package com.nh31gmail.natthiya.sm;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapters.MyFragmentPagerAdapter;
import fragments.Fragment1;
import fragments.Fragment2;
import fragments.Fragment3;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view_pager);

        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(),listFragments );
        viewPager.setAdapter(myFragmentPagerAdapter);


    }
}
