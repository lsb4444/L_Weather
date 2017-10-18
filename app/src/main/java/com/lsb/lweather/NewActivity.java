package com.lsb.lweather;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public class NewActivity extends AppCompatActivity {

    private Fragment mFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        if (savedInstanceState == null) {
            mFrag = getSupportFragmentManager().findFragmentById(R.id.frag2);
        }
    }


}
