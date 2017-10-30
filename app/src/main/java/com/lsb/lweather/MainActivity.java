package com.lsb.lweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    private Fragment mSerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            mSerc = getSupportFragmentManager().findFragmentById(R.id.frag);
        }

    }

}

