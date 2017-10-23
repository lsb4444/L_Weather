package com.lsb.lweather;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lsb.lweather.viewPage.fragment.NowFragment;

import static android.R.attr.fragment;


public class NewActivity extends AppCompatActivity {


    private String mCity;
    private NowWeatherFragment mFrag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        if (getIntent() != null) {
            mCity = getIntent().getStringExtra("city");


        }

        if (savedInstanceState == null) {
            mFrag = (NowWeatherFragment) getSupportFragmentManager().findFragmentById(R.id.frag2);
            mFrag.setmSetCity(mCity);


        }
    }


}
