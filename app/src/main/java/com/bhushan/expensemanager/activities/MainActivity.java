package com.bhushan.expensemanager.activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.bhushan.expensemanager.R;
import com.bhushan.expensemanager.adapters.SectionsPageAdapter;
import com.bhushan.expensemanager.fragments.BalanceFragment;
import com.bhushan.expensemanager.fragments.CustomBottomSheetDialogFragment;
import com.bhushan.expensemanager.fragments.ExpenseFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    public static FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager=findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CustomBottomSheetDialogFragment().show(getSupportFragmentManager(), "Dialog");

            }
        });

    }




    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExpenseFragment(),"Expenses");
        adapter.addFragment(new BalanceFragment(),"Balance");
        viewPager.setAdapter(adapter);
    }



}
