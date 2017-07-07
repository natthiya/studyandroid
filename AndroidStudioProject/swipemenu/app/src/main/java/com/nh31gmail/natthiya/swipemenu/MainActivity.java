package com.nh31gmail.natthiya.swipemenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TableLayout;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.OnTabChangeListener;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import adapters.MyFragmentPagerAdapter;
import fragments.Fragment1;
import fragments.Fragment2;
import fragments.Fragment3;

public class MainActivity extends AppCompatActivity implements OnTabChangeListener, OnPageChangeListener{

     TabHost tabHost;
     ViewPager viewPager;
     MyFragmentPagerAdapter myViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiViewPager();
        initTabHost();

    }

    private void initTabHost() {

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        String[] tabNames = {"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6"};
        for (int i=0 ;i<tabNames.length;i++)
        {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getApplicationContext()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);

    }

     public class FakeContent implements TabContentFactory {
         Context context;
         public FakeContent (Context mcontext){
             context = mcontext;
        }

         @Override
         public View createTabContent(String tag) {
             View fakeView = new View(context);
             fakeView.setMinimumHeight(0);
             fakeView.setMinimumWidth(0);
             return fakeView;
         }
    }

    private void initiViewPager() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        List<Fragment> listFragment = new ArrayList<Fragment>();

        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());
        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());

       MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabHost.setOnTabChangedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
        HorizontalScrollView hScrollView = (HorizontalScrollView) findViewById(R.id.h_scroll_view);
       View tabView = tabHost.getCurrentTabView();
       int scrollPos = tabView.getLeft()
             - (hScrollView.getWidth() - tabView.getWidth()) / 2;
       hScrollView.smoothScrollTo(scrollPos, 0);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);

    }

}
