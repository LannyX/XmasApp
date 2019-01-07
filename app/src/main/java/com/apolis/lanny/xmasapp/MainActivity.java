package com.apolis.lanny.xmasapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;



public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, MyInterface{


    //tablayout
    private TabLayout tabLayout;

    //viewPager
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tab1 fragmenttab = new Tab1();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout, fragmenttab).commit();

        //Adding toolbar to the activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.pager);

        Pager adaptor = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adaptor);

        tabLayout.setOnTabSelectedListener(this);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                tabLayout.setScrollPosition(i,0,true);
                tabLayout.setSelected(true);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void onTabSelected(Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(Tab tab) {

    }

    @Override
    public void onTabReselected(Tab tab) {

    }

    @Override
    public void passing(String name) {
        Tab2 tab2 = new Tab2();
        Bundle bundle = new Bundle();
        bundle.putString("key", name);

        tab2.setArguments(bundle);
        FragmentManager fm = this.getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.tab2View, tab2).addToBackStack(null).commit();
        viewPager.setCurrentItem(1);
    }
}
