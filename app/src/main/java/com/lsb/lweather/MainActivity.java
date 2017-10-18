package com.lsb.lweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

import static android.R.attr.fragment;


public class MainActivity extends AppCompatActivity {

    private Fragment mSerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
//            mSerc = new SearchWeatherFragment();
            mSerc = getSupportFragmentManager().findFragmentById(R.id.frag);


            // 왜 겹칠까
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.frag, mSerc)
//                    .commit();
        }


    }

}

