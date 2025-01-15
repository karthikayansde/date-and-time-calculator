package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sidebar.mode.ModeChange;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bnv;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mode set
        ModeChange mc;
        mc = new ModeChange(this);
        AppCompatDelegate.setDefaultNightMode(mc.getMode());

        bnv = findViewById(R.id.bnv);
        bnv.setSelectedItemId(R.id.home);
        fm = getSupportFragmentManager();
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        fm.beginTransaction().replace(R.id.fragmentContainerView,homeFragment.class,null).addToBackStack("name").commit();
                        return true;
                    case R.id.date:
                        fm.beginTransaction().replace(R.id.fragmentContainerView,dateFragment.class,null).addToBackStack("name").commit();
                        return true;
                    case R.id.time:
                        fm.beginTransaction().replace(R.id.fragmentContainerView,timeFragment.class,null).addToBackStack("name").commit();
                        return true;
                    case R.id.traval:
                        fm.beginTransaction().replace(R.id.fragmentContainerView,DateAddSubFragment.class,null).addToBackStack("name").commit();
                        return true;
                    case R.id.settings:
                        fm.beginTransaction().replace(R.id.fragmentContainerView,ModeFragment.class,null).addToBackStack("name").commit();
                        return true;
                }
                return false;
            }
        });


    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragmentContainerView);
        if(!(f instanceof homeFragment)){
            fm.beginTransaction().replace(R.id.fragmentContainerView,homeFragment.class,null).setReorderingAllowed(true).addToBackStack("name").commit();
            bnv.setVisibility(View.VISIBLE);
            bnv.setSelectedItemId(R.id.home);
        }
        else{
            super.onBackPressed();
            finish();
        }
    }
}
